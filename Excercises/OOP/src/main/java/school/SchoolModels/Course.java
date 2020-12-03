package school.SchoolModels;

import java.util.List;

public class Course {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private Teacher teacher;
    private Room room;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course(String name, Teacher teacher, Room room, List<Student> students) {
        this.name = name;
        this.teacher = teacher;
        this.room = room;
        this.students = students;
    }

    public Course(String name, String teacher, String room, List<String> students) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", room=" + room +
                ", students=" + students +
                '}';
    }
}
