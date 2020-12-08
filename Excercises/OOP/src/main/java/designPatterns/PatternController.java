package designPatterns;

import designPatterns.factory.greetFactory;
import designPatterns.mvc.StudentController;
import designPatterns.mvc.StudentModel;
import designPatterns.mvc.StudentView;
import designPatterns.strategy.multiplication;
import designPatterns.strategy.operation;
import designPatterns.template.CardGame;

public class PatternController {
    public static void main(String[] args) {

        //template
        var c = new CardGame();
        c.play();

        //factory
        greetFactory gf = new greetFactory();
        gf.getGreetType("all");

        //strategy
        operation op = new operation(new multiplication());
        System.out.println(op.executeStrategy(20,50));

        //mvc
        StudentModel model = fetchStudentFromDatabase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(view, model);
        controller.updateView();
        controller.setStudentName("Kurt");
        controller.updateView();
    }

    private static StudentModel fetchStudentFromDatabase() {
        StudentModel student = new StudentModel();
        student.setName("King");

        return student;
    }
}



