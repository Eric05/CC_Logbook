package database;

import java.sql.*;

public class DatabaseTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        Connection connect;
        PreparedStatement preparedStatement;

        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/test?"
                            + "user=root&password=my-secret-pw");
        } catch (SQLException throwables) {
            throw new SQLException();
        }

        // prepared statements
            // complex statement with parameters
        preparedStatement = connect.prepareStatement("insert into students values(default,?,?)");
        preparedStatement.setString(1, "king");
        preparedStatement.setString(2, "kong");
        preparedStatement.executeUpdate();

            // simple statement
        preparedStatement = connect.prepareStatement("SELECT * from students where id <= 3");
        ResultSet resultSet1 = preparedStatement.executeQuery();

        while (resultSet1.next()) {
            String lastname = resultSet1.getString("lastname");
            System.out.println(lastname);
        }

        // pure statements
        Statement statement = connect.createStatement();

        statement.executeUpdate("update students " +
                "set firstname='little', lastname='john'" +
                " where id=4");
        statement.executeUpdate("delete from students where id=5");

        ResultSet resultSet = statement
                .executeQuery("select * from students");

        while (resultSet.next()) {

            String lastname = resultSet.getString("lastname");
            String forename = resultSet.getString("firstname");
            int id = resultSet.getInt("id");

            System.out.println("id: " + id);
            System.out.println("forename: " + forename);
            System.out.println("lastname: " + lastname);

        }

        connect.close();
    }
}



