package notes.application.services;

import notes.persistence.MySqlConnector_Timezone;
import notes.persistence.models.Note;
import notes.persistence.repos.NoteRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NoteService implements NoteRepo {
    private final String conString = "jdbc:mysql://localhost:3306/notes?user=root&password=root&serverTimezone=Europe/Berlin";

    @Override
    public Note getNoteById(int id) {
        var con = MySqlConnector_Timezone.connect(conString);

        Note item = null;
        String text;
        Timestamp ts;
        int userid;
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("SELECT * FROM notes WHERE id=?");
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                text = rs.getString("note");
                ts = rs.getTimestamp("date");
                userid = rs.getInt("userId");
                item = new Note(id, text, ts, userid);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            MySqlConnector_Timezone.closeCon(con);
        }
        return item;
    }


    @Override
    public List<Note> getNotes() {
        var con = MySqlConnector_Timezone.connect(conString);
        List<Note> notes = new ArrayList<>();

        try {
            var ps = con.prepareStatement("SELECT * FROM Notes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                var id = rs.getString("id");
                var item = getNoteById(Integer.parseInt(id));
                notes.add(item);
            }
        } catch (SQLException throwable) {
            return null;
        } finally {
            MySqlConnector_Timezone.closeCon(con);
        }
        return notes;
    }

    @Override
    public void insertNote(String note, int id) {
        var con = MySqlConnector_Timezone.connect(conString);
        PreparedStatement preparedStatement;

        try {
            preparedStatement = con.prepareStatement("insert into notes values(default,?,default,?)");
            preparedStatement.setString(1, note);
            preparedStatement.setString(2, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            MySqlConnector_Timezone.closeCon(con);
        }
    }
}
