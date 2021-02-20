package fileIO;

public class Main {
    public static void main(String[] args) {

        PersonDao dao = new PersonDao_CsvImpl();

        var originalList = dao.getAllPersons();
        System.out.println(originalList.size());

        dao.addPerson("Marie");
        dao.addPerson("Hulk");
        var newList = dao.getAllPersons();

    }
}
