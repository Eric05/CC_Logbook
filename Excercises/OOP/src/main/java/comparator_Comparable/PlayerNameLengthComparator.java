package comparator_Comparable;

import java.util.Comparator;

public class PlayerNameLengthComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        return p1.getName().length() - p2.getName().length();
    }
}
