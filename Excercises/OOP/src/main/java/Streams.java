import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Steve", "John", "Sam");
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        var filtered = numbers.stream()
                .filter(n -> filterByAlgo(n))
                .collect(Collectors.toList());

        // map with index from list
        AtomicInteger index = new AtomicInteger();
        var indexedMap = names.stream().collect(
                Collectors.toMap(s -> index.getAndIncrement(), Function.identity()));

        // map method
        List<Integer> square = numbers.stream().map(x -> x * x).
                collect(Collectors.toList());
        System.out.println(square);

        // filter method
        List<String> result = names.stream().filter(s -> s.startsWith("S")).
                collect(Collectors.toList());
        System.out.println(result);

        // sorted method
        List<String> show = names.stream().sorted().collect(Collectors.toList());
        System.out.println(show);

        // create set
        Set<Integer> squareSet = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println(squareSet);

        // simple sout with forEach method
        numbers.stream().map(x -> x * x).forEach(System.out::println);

        // reduce: identity = start value,
        // res = result, i is each element in list; with method reference -> integer::sum
        int even = numbers.stream().filter(x -> x % 2 == 0).reduce(0, (res, i) -> res + i);

        System.out.println(even);


        // Object list
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
                .filter(n -> (Integer) n > 0)
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

    private static <T> boolean filterByAlgo(int input){
        if (input % 2 == 0 ){
            return true;
        }
        return false;
    }

}
