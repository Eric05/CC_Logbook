package designPatterns;

import designPatterns.observer_Progress.ProgressObserver;
import designPatterns.observer_Progress.Subject;
import designPatterns.state.Context;
import designPatterns.state.StartState;
import designPatterns.state.RunningState;


public class PatternController {
    public static void main(String[] args) throws InterruptedException {

        // observer progress + printProgress() in Main
        Subject subject = new Subject();

        new ProgressObserver(subject);
        Thread t1 = new Thread(() -> {
            try {
                printProgress(subject);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("starting");
        t1.start();
        while (t1.isAlive()) {
            Thread.sleep(2000);
            System.out.println("is running");
        }
        System.out.println("done");

        // state
/*        Context context = new Context();
        int counter = 10;

        StartState startState = new StartState();
        RunningState runState = new RunningState();

        for (int i = 0; i < counter; i++) {
            if (i < counter / 2) {
                startState.doAction(context);
                System.out.println(context.getState().toString());
            } else {
                runState.doAction(context);
                System.out.println(context.getState().toString());

            }
        }*/

/*        //  observer
        Subject subject = new Subject();

        new HexaObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

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

        return student;*/
    }

    public static void printProgress(Subject subject) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            subject.setState(i);
        }
    }
}



