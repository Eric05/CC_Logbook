package Comparator_Comparable;

import java.util.*;
import java.util.stream.Collectors;

/***
 * Comparable is defined in class by implementing Comparable<>
 *     -> Here it is in Player Class at the end
 *  Comparator is used if class can or should not be modified or we need complex logic
 *      -> can be achieved by lamda or by creating own class. Here PlayerRankingComparator
 */

public class Main {
    public static void main(String[] args) {

        // 1. create class man with name and size

        // 2. in Main create vector
        Vector<Man> men = new Vector<>();
        men.add(new Man("a", 160));
        men.add(new Man("x", 180));
        men.add(new Man("b", 170));
        men.add(new Man("c", 175));

        // sort by size
        men.sort(Comparator.comparingInt(Man::getSize));

        // sort by name and (optional) reverse
        men.sort(Comparator.comparing(Man::getName).reversed());

        var allPlayers = new InMemoryPlayers();
        var list = allPlayers.getPlayers();

        // by age using Comparable of Player
        Collections.sort(list);
        printList(list);

        // by Ranking using PlayerRankingComparator
        list.sort(new PlayerRankingComparator());
        printList(list);

        // comparator variable
        Comparator<Player> byRanking = Comparator
                .comparing(Player::getRanking);

        // by 1. using PlayerNameLengthComparator Class, 2. using variable, 3. using lambda
        // new var for creating new list (non destructive ) otherwise list = list.stream()...
        var sortedList = list.stream()
                .sorted(new PlayerNameLengthComparator().thenComparing(byRanking).thenComparing(p -> p.getAge()))
                .collect(Collectors.toList());

        printList(list);
    }

    public static void printList(List<Player> list) {
        for (Player player : list) {
            System.out.println(player.toString());
        }
        System.out.println("---------------------");
    }

    public static List<String> sortByLengthLamda(String[] strings) {
        List<String> list = Arrays.asList(strings);
        list.sort(Comparator.comparingInt(String::length).reversed());

        return list;
    }

    public static List<String> sortByAlphaLamda(String[] strings) {
        List<String> list = Arrays.asList(strings);
        // case Insensitiv - list.sort(String.CASE_INSENSITIVE_ORDER );
        list.sort(Comparator.naturalOrder());

        return list;
    }
}
