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
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        String workingDir = System.getProperty("user.dir") + File.separator + "atm.properties";
        var db = GetConfig.getProperty(workingDir, "db.user");
        View view = new View();
        AccountRepo accountRepo = new AccountService();
        TransactionRepo transRepo = new TransactionService();

        // 2000012345, 2000054321
        transRepo.doDeposit("2000054321", 87.95);
        transRepo.doWithdraw("2000054321", 100.9);
        //
        var amount = accountRepo.getBalance("2000054321");
        var list = transRepo.getLastTransactionsByNumber("2000054321");
        var li = CreateStatement.create(list, amount);
        WriteStatementToFile.write(li);
        writeToFile(transRepo);
    }

    private static void writeToFile(TransactionRepo transRepo) {

    }
}
