package atm.persistence.repos;

import atm.persistence.models.Transaction;

import java.util.List;

public interface TransactionRepo {
    List<Transaction> getTransactionsByNumber(String number);

    void doDeposit(String accountnumber, Double deposit);

    void doWithdraw(String accountnumber, Double withdraw);

    List<Transaction> getLastTransactionsByNumber(String s);
}
