package errorHandling;

import java.awt.*;
import java.io.IOException;

/***
 * try catch is used within method . program continues after catch
 * throw is used within method if exception is unchecked . program stops
 * throws is used within method signature -> checked exceptions are not propagated,
 * Exception can be handled in any method in call stack
 *
 * To create a custom exception, extend the java.lang.Exception class.
 *  -> IncorrectFileNameException
 * To create a custom unchecked exception extend the java.lang.RuntimeException class.
 *  -> IncorrectFileExtensionException
 */

public class Main {
    public static void main(String[] args) throws IncorrectFileNameException {


        DoSomething.divideByZero(4,0);

        try {
            var line = FileHandler.readFirstLine_Error("xyc");
        } catch (IncorrectFileNameException e) {
            e.printStackTrace();
        }


        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        Font[] fonts = ge.getAllFonts();
        for (Font f : fonts) {
            //if (f.getName().equals("Verdana")) {
                Font font = f.deriveFont(Font.BOLD, 16);
                System.out.println(font.getName() + ", " + font.getStyle()
                        + ", " + font.getSize());

        }

        try {
            DoSomething.readFile("xy");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("lets go on");
        }
    }
    public static void divide(){
        DoSomething.divideByZero(1,0);
    }
}
