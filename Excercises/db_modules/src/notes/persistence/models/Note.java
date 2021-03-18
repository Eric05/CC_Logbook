package notes.persistence.models;

import java.sql.Timestamp;

public class Note {

    private final int id;
    private final String text;
    private final Timestamp timestamp;
    private final int userid;

    public Note(int id, String text, Timestamp ts, int userid) {
        this.id = id;
        this.text = text;
        this.timestamp = ts;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getUserid() {
        return userid;
    }
}
