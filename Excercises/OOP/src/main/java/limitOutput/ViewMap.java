package limitOutput;

import java.util.Map;

public class ViewMap implements Viewable{

    @Override
    public <T> void handleLine(T lines, int buffer, int idx) {

        ((Map)lines).entrySet().stream().skip(idx).limit(buffer).forEach(System.out::println);
    }
}
