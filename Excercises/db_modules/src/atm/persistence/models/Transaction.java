package atm.persistence.models;

import java.util.Comparator;
import java.util.Date;

public class Transaction implements Comparator<Transaction> {
    private final Double amount;
    private final Date date;

    public Transaction(Double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }


    @Override
    public int compare(Transaction t1, Transaction t2) {
        return t1.getDate().compareTo(t2.getDate());
    }
}
