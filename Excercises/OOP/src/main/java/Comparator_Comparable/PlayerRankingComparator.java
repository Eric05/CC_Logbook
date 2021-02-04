package Comparator_Comparable;

import java.util.Comparator;

public class PlayerRankingComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        return Integer.compare(p1.getRanking(), p2.getRanking());
    }
}
