package limitOutput;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var map = generateMap();
        System.out.println(map.size());
        var values = map.values();
        limitOutput(map, 2,0);
    }

    private static <T> void limitOutput(T lines, int buffer, int idx) {
        int len;
        if (lines instanceof Map) {
            len = ((Map) lines).entrySet().size();
        } else {
            len = ((Collection)lines).size();
        }
        while (idx < len){
            Scanner sc = new Scanner(System.in);
            sc.next();
            if (lines instanceof Map) {
                ((Map)lines).entrySet().stream().skip(idx).limit(buffer).forEach(System.out::println);
            } else {
                ((Collection)lines).stream().skip(idx).limit(buffer).forEach(System.out::println);
            }

            idx += buffer;
        }
    }

    private static Map<String, Employee>generateMap() {
        Map<String, Employee> map = new HashMap<>();

        Employee employee1 = new Employee(1L, "Mher");
        map.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(22L, "Annie");
        map.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map.put(employee3.getName(), employee3);
        Employee employee4 = new Employee(2L, "George");
        map.put(employee4.getName(), employee4);

        return map;
    }
}
