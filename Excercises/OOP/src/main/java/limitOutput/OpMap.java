package limitOutput;

import java.util.Map;

public class OpMap implements Operable {
    @Override
    public <T> int getLength(T val) {
        return ((Map)val).size();
    }

    @Override
    public void handleLine() {

    }
}
