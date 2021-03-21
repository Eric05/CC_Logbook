import java.util.*;
import java.util.stream.Collectors;

public class SortMap_LimitOutput {

    public static void main(String[] args) {
        var map = generateMap();

        var sortedByKeys = map.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        sortedByKeys.entrySet().forEach(System.out::println);

        System.out.println("----------");

        var sortedByValues =  map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        sortedByValues.entrySet().forEach(System.out::println);

        System.out.println("------------------");
        sortedByValues.entrySet().stream().skip(2).limit(1).forEach(System.out::println);

        System.out.println("---------");
        limitOutput(sortedByKeys);

    }

    private static void limitOutput(Map<String, Employee> lines) {
        var len = lines.size();
        int buffer = 2;
        int idx = 0;
        while (idx < len){
            Scanner sc = new Scanner(System.in);
            sc.next();
            lines.entrySet().stream().skip(idx).limit(buffer).forEach(System.out::println);
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
