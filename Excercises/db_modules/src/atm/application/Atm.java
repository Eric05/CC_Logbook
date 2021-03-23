package atm.application;

import atm.View;
import atm.persistence.models.Transaction;
import atm.persistence.repos.AccountRepo;
import atm.persistence.repos.TransactionRepo;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class Atm {
    private final View view;
    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;
    private String actual;

    public Atm(View view, AccountRepo accountRepo, TransactionRepo transactionRepo) {
        this.view = view;
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    public void dailyRoutine(String name) {
        view.printInfo(name.toUpperCase(Locale.ROOT));
        actual = login(view, accountRepo);
        printTotal(view, actual);

        while (true) {
            printMenu();
            var inp = view.getInput();
            switch (inp) {
                case "1":
                    printTransactions(transactionRepo.getTransactionsByNumber(actual));
                    break;
                default:
                    actual = null;
                    view.printInfo("Goodbye");
            }
        }
    }

    private String login(View view, AccountRepo repo) {
        view.printInfo("Number");
        var nr = view.getInput();
        view.printInfo("Pin");
        var pin = view.getInput();

        if (repo.isLoginValid(nr, pin)) {
            return nr;
        }
        return null;
    }

    private void printMenu() {
        view.printInfo("1 to show trans | 2 to deposit | 3 to withdraw | 4 to quit");
    }

    private void printTransactions(List<Transaction> transactions) {
        String euro = "\u20ac";
        view.printInfo("Your Transactions: ");

        for (var transaction : transactions) {
            var amount = transaction.getAmount();
            String day = new SimpleDateFormat("MM dd yyyy").format(transaction.getDate());
            String time = new SimpleDateFormat("HH:mm:ss").format(transaction.getDate());
            System.out.println(day + " at: " + time);
            if (amount >= 0) {
                view.printInfo(("\t+" + amount + euro));
            } else {
                view.printWarning("\t" + (amount + euro));
            }
        }
    }

    private void printTotal(View view, String accountnumber) {
        view.printInfo("TOTAL AMOUNT: " + accountRepo.getBalance(accountnumber));
    }
}
