package atm.application.services;

import atm.persistence.MySqlConnector_Timezone;
import atm.persistence.repos.AccountRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService implements AccountRepo {
    private final String CON_STR = "jdbc:mysql://localhost:3306/bank?user=root&password=root&serverTimezone=Europe/Berlin";
    private Connection con;


    @Override
    public boolean isLoginValid(String accountNumber, String pin) {
        con = MySqlConnector_Timezone.connect(CON_STR);

        try {

            var preparedStatement = con.prepareStatement("select * from account where accountnumber = ? and pin = sha2(?,512)");
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, pin);
            var resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public List<String> getTransactions(String num) {
        con = MySqlConnector_Timezone.connect(CON_STR);

        List<String> transactions = new ArrayList<>();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("SELECT amount, date \n" +
                    "FROM bank.transaction\n" +
                    "where not amount  = 0.00\n" +
                    "AND accountnumber =?");

            ps.setString(1, String.valueOf(num));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                var amount = rs.getString("amount");
                var date = rs.getString("date");
                transactions.add(amount + "," + date);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            atm.persistence.MySqlConnector_Timezone.closeCon(con);
        }
        return transactions;
    }


    @Override
    public String getBalance(String number) {
        con = MySqlConnector_Timezone.connect(CON_STR);

        String balance = "";
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("SELECT * FROM balance WHERE accountnumber=?");
            ps.setString(1, String.valueOf(number));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                balance = rs.getString("sum(amount)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            atm.persistence.MySqlConnector_Timezone.closeCon(con);
        }
        return balance;
    }

}
