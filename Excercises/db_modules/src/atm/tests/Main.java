package atm.tests;

import atm.View;
import atm.application.GetConfig;
import atm.application.services.AccountService;
import atm.application.services.TransactionService;
import atm.application.statement.CreateStatement;
import atm.application.statement.WriteStatementToFile;
import atm.persistence.repos.AccountRepo;
import atm.persistence.repos.TransactionRepo;

import java.io.File;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path workingDir = Path.of(System.getProperty("user.dir"));
        var db = GetConfig.getProperty(workingDir + File.separator + "atm.properties", "db.user");
        View view = new View();
        AccountRepo accountRepo = new AccountService();
        TransactionRepo transRepo = new TransactionService();

        // 2000012345, 2000054321
        transRepo.doDeposit("2000054321", 87.95);
        transRepo.doWithdraw("2000054321", 100.9);
        //
        var amount = accountRepo.getBalance("2000012345");
        var list = transRepo.getLastTransactionsByNumber("2000054321");
        var li = CreateStatement.create(list, amount);
        WriteStatementToFile.write(li);
        writeToFile(transRepo);
    }

    private static void writeToFile(TransactionRepo transRepo) {

    }
}
