package designPatterns.mvc;

public class StudentController {
    private StudentView view;
    private StudentModel student;

    public StudentController(StudentView v, StudentModel s){
        view = v;
        student = s;
    }

    public String getStudentName(){
        return student.getName();
    }

    public void setStudentName(String name){
        student.setName(name);
    }
    public void updateView(){
        view.printStudentName(student.getName());
    }
}
