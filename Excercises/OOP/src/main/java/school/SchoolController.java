package school;

import school.DataConnection.Connection;
import school.DataConnection.CsvConnection;
import school.SchoolModels.*;
import java.io.IOException;


public class SchoolController {
    //region PATH Variables
    final static String NAME = "AK";
    final static String ADRESS = "Feldkirch";

    //endregion
    static Connection con = new CsvConnection();

    public static void main(String[] args) throws IOException {

        var adresses = con.getNamesAndAdresses();
        routine();

        printCourseInfo("Coding");

    }

    public static void routine() throws IOException {
        var courses = con.getAllCourses();

        greeting();
        var inp = SchoolView.getUserInput();
        printCourses();
        var inpCourse = SchoolView.getUserInput();
        SchoolView.printAllCoursesInfo(courses);
    }

    public static void greeting() {
        var b = new Building(NAME, ADRESS);
        SchoolView.greeting(b);
    }

    public static void printCourses() {
        var directories = con.getCourseNames();
        SchoolView.printCourses(directories);
    }

    public static void printCourseInfo(String name) throws IOException {
        var courses = con.getAllCourses();
        var course = (courses.stream().filter(c -> name.equals(c.getName()))
                .findFirst()).orElse(null);
        assert course != null;
        SchoolView.printCourseInfo(course);
    }



}
