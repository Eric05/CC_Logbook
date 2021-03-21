package notes.persistence.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Note> notes = new ArrayList<>();
    private final String name;
    private int id;
    private String password;

    public User(String name) {
        this.name = name;
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public Object getId() {
        return id;
    }
}
