import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {
    public static void main(String[] args) {

        var list = new ArrayList<Integer>();
        list.add(4);
        list.add(7);
        list.add(8);
        list.add(15);

/*        for (Integer i : list) {
            if (i < 5){
                list.remove(i);
            }
        }
        throws error -> at java.base/java.util.ArrayList$Itr.checkForComodification
        */

        // solution 1:
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            var i = it.next();
            if (i < 5 ){
                it.remove();
            }
        }

        // solution 2:
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i) < 8 ){
                list.remove(i);
            }
        }

        // solution 3:
        var copy = new ArrayList<>(list);
        for (int i = 0; i < copy.size() ; i++) {
            if (copy.get(i) < 10){
                list.remove(i);
            }
        }

        System.out.println(list.toArray().toString());
    }
}
