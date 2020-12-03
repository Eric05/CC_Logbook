package school;

import school.SchoolModels.Building;
import school.SchoolModels.Course;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SchoolView {

    public static void greeting(Building b) {

        System.out.println("Welcome to " + b.getName() + " " + b.getAddress());
        System.out.println(" Press c to see all courses");
    }

    public static void printCourses( String[] directories){
        System.out.println("Our actual courses:");
        System.out.println(Arrays.toString(directories));
    }

    public static void printCourseInfo(Course course){
        System.out.println();
        System.out.println("Info for " + course.getName());
        System.out.println(course.toString());
    }

    public static void printAllCoursesInfo(List<Course> courses){
        for (var course : courses) {
            System.out.println(course.toString());
        }
    }

    public static void printContent(List content){
        for (var o : content) {
            System.out.println(o.toString());
        }
    }

    public static String getUserInput(){
        Scanner sc = new Scanner(System.in);
        var inp = sc.next();

        return inp;
    }
}
