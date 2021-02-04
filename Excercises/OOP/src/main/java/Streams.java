import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add(new Date());
        list.add("B");
        list.add("D");
        list.add(12);
        list.add(1);
        list.add(12);

        // print list
        list.forEach(System.out::println);

        // filter numbers and limit to 1
        list.stream()
                .filter(n -> n instanceof Integer)
                .filter(number -> (Integer) number > 0)
                .limit(1)
                .forEach(System.out::println);

        // filter numbers and square
        List<Integer> squares = list.stream()
                .filter(n -> n instanceof Integer)
                .map(n -> (Integer) n * (Integer) n)
                .collect(Collectors.toList());

        System.out.println(squares.toString());

        // create frequency map
        Map<Object, Long> freq = list.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        System.out.println(freq);


/*
Filter map by Value
        Map<Integer, String> result = hmap.entrySet()
                .stream()
                .filter(map -> "xy".equals(map.getValue()))
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
                */
    }

}
