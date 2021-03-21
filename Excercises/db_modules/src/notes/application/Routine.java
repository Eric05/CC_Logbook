package notes.application;

import notes.application.services.NoteService;
import notes.application.services.UserService;
import notes.persistence.models.Note;
import notes.persistence.models.User;
import notes.persistence.repos.NoteRepo;
import notes.persistence.repos.UserRepo;
import notes.view.View;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Routine {

    private final View view = new View();
    private User actual = null;

    public Routine() {
        printWelcome();
        printMenu();
        doRoutine();
    }

    public void doRoutine() {
        NoteRepo repo = new NoteService();

        while (true) {
            var notes = repo.getNotes();
            var map = getMapByDay(notes);

            var inp = view.getInput();
            switch (inp) {
                case "1":
                    printNotes(map);
                    printMenu();
                    break;
                case "2":
                    doLogin();
                    printMenu();
                    break;
                case "3":
                    doRegistration();
                    printMenu();
                    break;
                default:
                    saveValidPost(inp);
                    printMenu();
            }
        }
    }

    private void printWelcome() {
        view.printMessage("Welcome on notes".toUpperCase(Locale.ROOT));
    }

    private void printMenu() {
        view.printMessage("\t press [1] to read notes");
        view.printMessage("\t press [2] to login | [3] to register");
        view.printInfo("Write your note:");
    }

    private void printNotes(Map<String, List<Note>> notes) {
        var values = notes.entrySet();

        for (var v : values) {
            var key = v.getKey();
            view.printMessage("");
            view.printMessage("------ " + key + " ------");

            var vals = v.getValue();

            for (Note n : vals) {
                view.printMessage("Note " + n.getId() + ": ");
                view.printMessage("\"" + n.getText() + "\"");
                String s = new SimpleDateFormat("HH:mm:ss").format(n.getTimestamp());
                String name = getUsername(n);
                view.printMessage(name + ": " + s);
                view.printMessage("");
            }
        }
    }

    private String getUsername(Note n) {
        var repo = new UserService();
        User user = null;

        try {
            user = repo.getUserById(n.getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (user == null) ? "Anonym" : user.getName();
    }

    private void doRegistration() {
        Registration reg = new Registration();

        view.printMessage("username");
        var name = view.getInput();
        view.printMessage("password");
        var pw = view.getInput();
        reg.registerUser(name, pw);

        UserRepo userRepo = new UserService();
        actual = userRepo.getUser(name);
        view.printInfo("Welcome " + actual.getName());
    }

    private void doLogin() {
        UserRepo userRepo = new UserService();
        Registration reg = new Registration();

        view.printMessage("username");
        var name = view.getInput();
        view.printMessage("password");
        var pw = view.getInput();

        if (reg.isValid(name, pw)) {
            actual = userRepo.getUser(name);
            view.printInfo("Welcome " + actual.getName());
        } else {
            view.printWarning("ERROR. Please log in again");
        }
    }

    private void saveValidPost(String msg) {
        NoteRepo repo = new NoteService();

        if (actual != null) {
            repo.insertNote(msg, Integer.parseInt(actual.getId().toString()));
            view.printInfo("thanks for posting");
        } else {
            view.printWarning("login to make post :)");
        }
    }

    private Map<Integer, List<Note>> getMapByUser(List<Note> notes, int userid) {
        return notes.stream()
                .collect(
                        Collectors.groupingBy(Note::getUserid,
                                Collectors.mapping((Note n) -> n, toList())));
    }

    private Map<Integer, List<Note>> getMapByUserid(List<Note> notes, int userid) {
        var groupedByUser = notes.stream()
                .collect(
                        Collectors.groupingBy(Note::getUserid,
                                Collectors.mapping((Note n) -> n, toList())));

        return groupedByUser.entrySet().stream()
                .filter(x -> x.getKey() == userid)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<String, List<Note>> getMapByDay(List<Note> notes) {
        var map = notes.stream()
                .collect(
                        Collectors.groupingBy(n -> new SimpleDateFormat("MM/dd/yyyy").format(n.getTimestamp()),
                                Collectors.mapping((Note n) -> n, toList())));
        return sortByKeys(map);

    }

    private <K extends Comparable, V> Map<K, V> sortByKeys(Map<K, V> map) {
        return new TreeMap<>(map);
    }
}


