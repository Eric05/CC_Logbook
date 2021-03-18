package notes.application;

import notes.persistence.MySqlConnector_Timezone;
import notes.persistence.models.User;
import notes.persistence.repos.UserRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService implements UserRepo {

    private final String conString = "jdbc:mysql://localhost:3306/notes?user=root&password=root&serverTimezone=UTC";

    @Override
    public User getUserById(int id) {
        var con = MySqlConnector_Timezone.connect(conString);

        User item = null;
        String name;
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("SELECT * FROM user WHERE id=?");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
                item = new User(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            MySqlConnector_Timezone.closeCon(con);
        }
        return item;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void registerUser(String name, String password) {
        var con = MySqlConnector_Timezone.connect(conString);
        try {
            var ps = con.prepareStatement("insert into user values(default,?,?)");
            ps.setString(1, name);
            ps.setString(2, password);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            MySqlConnector_Timezone.closeCon(con);
        }
    }

    @Override
    public User getUser(String name, String pw) {
        User user = null;
        var con = MySqlConnector_Timezone.connect(conString);

        try {
            var ps = con.prepareStatement("SELECT * FROM user WHERE name=? AND password=?");
            ps.setString(1, name);
            ps.setString(2, pw);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                var nam = rs.getString("name");
                var id = rs.getString("password");
                user = new User(nam);

            }
        } catch (SQLException throwables) {
            return null;
        }
        return user;
    }

    @Override
    public User getUser(String name) {
        User user = null;
        var con = MySqlConnector_Timezone.connect(conString);

        try {
            var ps = con.prepareStatement("SELECT * FROM user WHERE name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                var nam = rs.getString("name");
                var id = rs.getString("id");
                user = new User(nam, Integer.parseInt(id));
            }
        } catch (SQLException throwables) {
            return null;
        }
        return user;
    }
}
