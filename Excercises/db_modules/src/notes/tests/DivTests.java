package notes.tests;

import notes.application.services.NoteService;
import notes.persistence.repos.NoteRepo;
import org.junit.Test;

public class DivTests {

    @Test
    public void bubbleSortedShortTest() throws InterruptedException {
        NoteRepo repo = new NoteService();
        var notes = repo.getNotes();


    }


}
