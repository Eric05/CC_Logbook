import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class CopyCollections {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Object> list = new ArrayList<>();

        //region List
        list.add("A");
        list.add("B");
        list.add(new Date());
        list.add("C");
        list.add("D");
        //endregion

        // shallow copy -> references are copied; each change of copy changes the original
        var clone1 = new ArrayList<>(list);

        // deprecated -> can throw has protected access
        var clone = (ArrayList<Object>) list.clone();

        // deep copy -> creates independent new object
        var deepClone = new ArrayList<>();
        Iterator it = list.iterator();

        while (it.hasNext()) {
            // for mutable objects we have to create new instance
            if (it instanceof Date) {
                deepClone.add(new Date(((Date) it).getTime()));
            } else {
                // primitive Datatypes, Strings and wrapper can be 
                deepClone.add(it.next());
            }
        }
    }
}
