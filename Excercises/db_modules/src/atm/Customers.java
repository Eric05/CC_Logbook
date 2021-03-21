package atm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customers {

    // const Path
    private final static String PATH = "C:\\dev\\Customers.txt";
    private final List<Customer> customers = new ArrayList<>();

    public Customers() throws IOException {
        getListFromCSV(PATH);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    private void getListFromCSV(String path) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(PATH));

        for (var l : lines) {
            var props = l.split(",");
            customers.add(new Customer(props[0], props[1], Double.valueOf(props[2])));
        }
    }

    private String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                sb.append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("wrong path");
        }

        return sb.toString();
    }

    //  var str = cus.readFileAsString().split("\\R");
    public String readFileAsString() throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(PATH)));
        return data;
    }
}

