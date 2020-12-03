package school.DataConnection;

import school.SchoolModels.Course;
import school.SchoolModels.Room;
import school.SchoolModels.Student;
import school.SchoolModels.Teacher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CsvConnection implements Connection {

    //region PATH Variables
    final static String PATH_TEACHERS = "C:\\dev\\School\\Teachers.txt";
    final static String PATH_ROOMS = "C:\\dev\\School\\Rooms.txt";
    final static String PATH_COURSE = "C:\\dev\\School\\Courses";
    //endregion

    @Override
    public List<Course> getAllCourses() throws IOException {
        return getMappedCourses();
    }

    @Override
    public List<String> getNamesAndAdresses() throws IOException {
        List<String> adresses = new ArrayList<>();
        var teachers = getTeachers();
        var students = getStudents();

        for (Teacher teacher : teachers) {
            adresses.add(teacher.getName() + " ; " + teacher.getAdress());
        }
        for (Student s : students) {
            adresses.add(s.getName() + " ; " + s.getAdress());
        }
        return  adresses;
    }

    public void createCourse(Course course) throws IOException {
        String path = PATH_COURSE + File.separator + course.getName();

        File Dir = new File(path);
        if (!Dir.exists()) {
            Dir.mkdirs();
        }

        File f = new File(path + File.separator + "info");
        if (!f.exists()) {
            f.createNewFile();
        }

        Dir = new File(path + File.separator + "Students");
        if (!Dir.exists()) {
            Dir.mkdirs();
        }
    }

    public String[] getCourseNames() {
        File file = new File(PATH_COURSE);

        return file.list((current, name) -> new File(current, name).isDirectory());
    }

    private List<Course> getMappedCourses() throws IOException {
        List<Course> courses = new ArrayList<>();
        List<Teacher> teachers = getTeachers();
        List<Room> rooms = getRooms();

        File file = new File(PATH_COURSE);
        String[] directories = Objects.requireNonNull(file.list((current, name) -> new File(current, name).isDirectory()));

        for (String directory : directories) {
            List<String> info = Files.readAllLines(Path.of(PATH_COURSE + File.separator + directory + File.separator + "info"));
            List<Student> students = new ArrayList<>();

            var t = (teachers.stream().filter(teacher -> info.get(0).equals(teacher.getName()))
                    .findFirst()).orElse(null);
            var r = (rooms.stream().filter(room -> Integer.parseInt(info.get(1)) == (room.getFloor()))
                    .findFirst()).orElse(null);

            File fi = new File(PATH_COURSE + File.separator + directory + File.separator + "Students");
            String[] studentList = Objects.requireNonNull(fi.list((current, name) -> new File(current, name).isFile()));

            for (String s : studentList) {
                List<String> studentInfo = Files.readAllLines(Path.of(PATH_COURSE + File.separator + directory + File.separator + "Students" + File.separator + s));
                Student st = new Student(studentInfo.get(0), studentInfo.get(1), studentInfo.get(2));
                students.add(st);
            }
            Course c = new Course(directory, t, r, students);
            courses.add(c);
        }
        return courses;
    }

    private List<Teacher> getTeachers() throws IOException {
        List<String> lines = Files.readAllLines(Path.of(PATH_TEACHERS));
        List<Teacher> teachers = new ArrayList<>();

        for (String line : lines) {
            Teacher t = new Teacher(line.split(",")[0], line.split(",")[1], line.split(",")[2]);
            teachers.add(t);
        }
        return teachers;
    }

    private List<Student> getStudents() throws IOException {
        List<Student> students = new ArrayList<>();

        File file = new File(PATH_COURSE);
        String[] directories = Objects.requireNonNull(file.list((current, name) -> new File(current, name).isDirectory()));

        for (String directory : directories) {
            File fi = new File(PATH_COURSE + File.separator + directory + File.separator + "Students");
            String[] names = Objects.requireNonNull(fi.list((current, name) -> new File(current, name).isFile()));

            for (String name : names) {
                List<String> studentInfo = Files.readAllLines(Path.of(PATH_COURSE + File.separator + directory + File.separator + "Students" + File.separator + name));
                Student st = new Student(studentInfo.get(0), studentInfo.get(1), studentInfo.get(2));
                students.add(st);
            }
        }
        return students;
    }

    private List<Room> getRooms() throws IOException {
        List<String> lines = Files.readAllLines(Path.of(PATH_ROOMS));
        List<Room> teachers = new ArrayList<>();

        for (String line : lines) {
            Room t = new Room(Integer.parseInt(line.split(",")[0]), Integer.parseInt(line.split(",")[1]));
            teachers.add(t);
        }
        return teachers;
    }

    /*    protected static void addStudentByCourseName(String course, Student student) throws IOException {
        var f = new File(PATH_COURSE + File.separator + course + File.separator + "Students");
        if (!f.exists()) {
            System.out.println("Course not created yet");
            throw new IllegalCallerException();
        }
        var path = PATH_COURSE + File.separator + course + File.separator + "Students" + File.separator + student.getName();
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        writeStudentToFile(path, student);
    }

    private static void writeStudentToFile(String path, Student s) throws IOException {
        String info = s.toString();
        Files.writeString(Path.of(path), info);
    }

    protected static Teacher mapTeacherToObject(String name) throws IOException {
        List<String> teachers = Files.readAllLines(Path.of(PATH_TEACHERS));
        var actual = teachers.stream().filter((t) -> t.contains(name)).findFirst().orElse(null).split(",");
        var teacher = new Teacher(actual[0], actual[1]);

        return teacher;
    }*/
}
