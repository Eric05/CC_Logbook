package notes.persistence.repos;

import notes.persistence.models.Note;

import java.util.List;

public interface NoteRepo {

    Note getNoteById(int id);

    List<Note> getNotes();

    void insertNote(String note, int id);

}
