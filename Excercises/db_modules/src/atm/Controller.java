package atm;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Controller {

    public void init() throws IOException, NoSuchAlgorithmException {
        View v = new View();

        v.printWelcomeScreen();
        var pin = v.getPin();
        if (isValidPin(pin) != null) {
            var actualCustomer = isValidPin(pin);
            routine(v, actualCustomer);
        } else {
            init();
        }
    }

    public Customer isValidPin(String pin) throws IOException, NoSuchAlgorithmException {
        Customers cu = new Customers();
        var customers = cu.getCustomers();

        for (var c : customers) {
            var hashed = getHexFromSHA((getSHA(pin)));
            var hashInput = c.getPin();
            if (hashed.equals(hashInput)) {
                return c;
            }
        }
        return null;
    }

    public void routine(View v, Customer customer) {

        v.printMenu();
        var menu = v.getMenuInput();

        switch (menu) {
            case 4:
                break;
            case 1: {
                v.printAmount(customer.getBalance());
                routine(v, customer);
            }
            case 2:
                doWithdraw(v);
                routine(v, customer);
                break;
            case 3:
                doDeposit(v);
                routine(v, customer);
        }
    }

    public void doWithdraw(View v) {
        var possibleWithdraw = MoneyOperations.getAmount();
        v.askForAmount();
        var amount = v.getAmount();
        if (isValidWithdraw(possibleWithdraw, amount)) {
            MoneyOperations.getMoney(amount);
        }
        v.printAmount(MoneyOperations.getAmount());
    }

    public void doDeposit(View v) {
        v.askForAmount();
        var amountPlus = v.getAmount();
        MoneyOperations.payMoney(amountPlus);
        v.printAmount(MoneyOperations.getAmount());
    }

    private boolean isValidWithdraw(double possible, int desired) {
        return !(desired > possible);
    }

    public byte[] getSHA(String input) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public String getHexFromSHA(byte[] hash) {

        var number = new BigInteger(1, hash);
        var hex = new StringBuilder(number.toString(16));

        while (hex.length() < 32) {
            hex.insert(0, '0');
        }
        return hex.toString();
    }
}
