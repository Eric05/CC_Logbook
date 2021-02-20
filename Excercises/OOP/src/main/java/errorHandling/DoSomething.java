package errorHandling;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DoSomething {

    public static void divideByZero(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divison by Zero");
        }
    }

    @Test
    public static void initCounting(int max) {

        for (int i = 0; i < max; i++) {
            count();
        }
    }

    public static void count() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hi");
    }

    public static void readFile(String path) throws IOException {

        if (!new File(path).exists()) {
            throw new IOException();
        }
        List<String> lines = Files.readAllLines(Path.of(path));

    }

}
