package atm.application.services;

import atm.persistence.MySqlConnector_Timezone;
import atm.persistence.models.Transaction;
import atm.persistence.repos.TransactionRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionService implements TransactionRepo {
    private final String CON_STR = "jdbc:mysql://localhost:3306/bank?user=root&password=root&serverTimezone=Europe/Berlin";
    private Connection con;

    @Override
    public List<Transaction> getTransactionsByNumber(String num) {
        con = MySqlConnector_Timezone.connect(CON_STR);

        List<Transaction> transactions = new ArrayList<>();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("SELECT amount, date \n" +
                    "FROM bank.transaction\n" +
                    "where not amount  = 0.00\n" +
                    "AND accountnumber =?");

            ps.setString(1, String.valueOf(num));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                var amount = Double.parseDouble(rs.getString("amount"));
                var date = rs.getTimestamp("date");
                transactions.add(new Transaction(amount, date));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            atm.persistence.MySqlConnector_Timezone.closeCon(con);
        }
        return transactions;
    }

    @Override
    public void doDeposit(String accountnumber, Double deposit) {
        con = MySqlConnector_Timezone.connect(CON_STR);
        PreparedStatement preparedStatement;

        try {
            preparedStatement = con.prepareStatement("insert into transaction values(default,default,?,?)");
            preparedStatement.setDouble(1, deposit);
            preparedStatement.setString(2, accountnumber);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            notes.persistence.MySqlConnector_Timezone.closeCon(con);
        }
    }

    @Override
    public void doWithdraw(String accountnumber, Double withdraw) {
        con = MySqlConnector_Timezone.connect(CON_STR);
        PreparedStatement preparedStatement;

        try {
            preparedStatement = con.prepareStatement("insert into transaction values(default,default,?,?)");
            preparedStatement.setDouble(1, -withdraw);
            preparedStatement.setString(2, accountnumber);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            notes.persistence.MySqlConnector_Timezone.closeCon(con);
        }
    }


    public List<Transaction> getLastTransactionsByNumber(String num) {
        con = MySqlConnector_Timezone.connect(CON_STR);

        List<Transaction> transactions = new ArrayList<>();
        PreparedStatement ps, ps1;

        try {
            ps = con.prepareStatement("call bank.selectTransactions(?)");
            ps1 = con.prepareStatement("call bank.saveTimestamp(?)");

            ps.setString(1, String.valueOf(num));
            ps1.setString(1, String.valueOf(num));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                var amount = Double.parseDouble(rs.getString("amount"));
                var date = rs.getTimestamp("date");
                transactions.add(new Transaction(amount, date));
            }
            ps1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            atm.persistence.MySqlConnector_Timezone.closeCon(con);
        }

        return transactions;
    }

}
