package atm.application.statement;

import atm.persistence.models.Transaction;

import java.util.List;

public class CreateStatement {

    public static String create(List<Transaction> transactions, String amount) {
        StringBuilder sb = new StringBuilder();

        for (Transaction transaction : transactions) {
            sb.append(transaction.getDate())
                    .append(System.lineSeparator())
                    .append(+transaction.getAmount())
                    .append(System.lineSeparator());
        }
        sb.append("Actual amount: " + amount);
        return sb.toString();
    }
}
