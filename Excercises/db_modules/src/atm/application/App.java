package atm.application;

import atm.View;
import atm.application.services.AccountService;
import atm.application.services.TransactionService;
import atm.persistence.models.Transaction;
import atm.persistence.repos.AccountRepo;
import atm.persistence.repos.TransactionRepo;

import java.text.SimpleDateFormat;
import java.util.List;

public class App {
    public static void main(String[] args) {

        TransactionRepo transRepo = new TransactionService();
        AccountRepo repo = new AccountService();
        String accountnumber = "2000012345";
        var amount = repo.getBalance("2000012345");
        var transactions = transRepo.getTransactionsByNumber(accountnumber);

        printTransactions(transactions, amount);

    }

    // simple controller
    private static void printTransactions(List<Transaction> transactions, String total) {
        View view = new View();
        String euro = "\u20ac";
        view.printInfo("Amount: " + euro + total);
        view.printInfo("Your Transactions: ");

        for (var transaction : transactions) {
            var amount = transaction.getAmount();
            String day = new SimpleDateFormat("MM dd yyyy").format(transaction.getDate());
            String time = new SimpleDateFormat("HH:mm:ss").format(transaction.getDate());
            System.out.println(day + " at: " + time);
            if (amount <= 0) {
                view.printInfo(("\t" + amount + euro));
            } else {
                view.printWarning("\t" + (amount + euro));
            }
        }
    }

}
