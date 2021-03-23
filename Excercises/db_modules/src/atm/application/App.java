package atm.application;

import atm.View;
import atm.application.services.AccountService;
import atm.application.services.TransactionService;
import atm.persistence.repos.AccountRepo;
import atm.persistence.repos.TransactionRepo;

public class App {
    public static void main(String[] args) {

        try {
            var pathToConfig = args[0];
        } catch (Exception e) {

        }

        View view = new View();
        AccountRepo accountRepo = new AccountService();
        TransactionRepo transRepo = new TransactionService();

        Atm atm = new Atm(view, accountRepo, transRepo);
        atm.dailyRoutine("[ Bankomat Miami ]");
    }
}
