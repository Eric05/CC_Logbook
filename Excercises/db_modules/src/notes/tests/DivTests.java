package notes.tests;

import notes.application.NoteService;
import notes.persistence.repos.NoteRepo;
import org.junit.Assert;
import org.junit.Test;
import notes.application.Routine;
import java.util.LinkedHashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

    public class DivTests
    {

     @Test
        public void bubbleSortedShortTest() throws InterruptedException {
         NoteRepo repo = new NoteService();
         var notes = repo.getNotes();


        }



}
