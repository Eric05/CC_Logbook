package atm.persistence.repos;

import java.util.List;

public interface AccountRepo {
    List<String> getTransactions(String num);

    String getBalance(String num);

    boolean isLoginValid(String accountNumber, String pin);
}
