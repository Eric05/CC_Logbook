package comparator_Comparable;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPlayers {

    private List<Player> players;

    public InMemoryPlayers() {
        players = new ArrayList<>();

        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 27);
        Player player3 = new Player(45, "Steven", 24);
        Player player4 = new Player(33, "John", 20);

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
