package notes.tests;

import notes.application.NoteService;
import notes.application.UserService;
import notes.persistence.models.Note;
import notes.persistence.repos.NoteRepo;
import notes.persistence.repos.UserRepo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Test {
    public static void main(String[] args) {
        NoteRepo repo = new NoteService();

        var notes = repo.getNotes();
   getMapByUserid(notes, 2);


        System.out.println("");
    }

    private static Map<Integer, List<Note>> getMapByUserid(List<Note> notes, int userid) {
        UserRepo userRepo = new UserService();

        var groupedByUser =  notes.stream()
                .collect(
                        Collectors.groupingBy(Note::getUserid,
                                Collectors.mapping((Note n) -> n, toList())));

        var postsByUserid = groupedByUser.entrySet().stream()
                .filter(x -> x.getKey() == userid)
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

        return postsByUserid;

 /*       var entries = postsByUserid.entrySet();

        for (Map.Entry<Integer, List<Note>> entry : entries) {
            System.out.println(userRepo.getUserById(entry.getKey()).getName());
            var val = entry.getValue();
            val.stream().forEach(n ->  System.out.println(" - " + n.getText()));
        }*/
    }
}
