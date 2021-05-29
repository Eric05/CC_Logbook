/*
package dataBases.mySql;

import java.sql.ResultSet;
import java.sql.Statement;

public class SqlStatements {
    // prepared statements
    // complex statement with parameters
    preparedStatement = connect.prepareStatement("insert into student values(default,?,?)");
        preparedStatement.setString(1, "kaa");
        preparedStatement.setString(2, "waa");
        preparedStatement.executeUpdate();

    // simple statement
    preparedStatement = connect.prepareStatement("SELECT * from student where id <= 3");
    ResultSet resultSet1 = preparedStatement.executeQuery();

        while (resultSet1.next()) {
        String lastname = resultSet1.getString("lastname");
        System.out.println(lastname);
    }

    // pure statements -> execute statement
    Statement statement = connect.createStatement();

        statement.executeUpdate("update student " +
                "set firstname='little', lastname='john'" +
                " where id=4");
    // statement.executeUpdate("delete from students where id=5");


    // fetch data
    ResultSet resultSet = statement
            .executeQuery("select * from student");

        while (resultSet.next()) {

        String lastname = resultSet.getString("lastname");
        String forename = resultSet.getString("firstname");
        int id = resultSet.getInt("id");

        System.out.println("id: " + id);
        System.out.println("forename: " + forename);
        System.out.println("lastname: " + lastname);

//    }

*/
