package atm.persistence.repos;

import atm.persistence.models.Transaction;

import java.util.List;

public interface TransactionRepo {
    List<Transaction> getTransactionsByNumber(String number);
}
