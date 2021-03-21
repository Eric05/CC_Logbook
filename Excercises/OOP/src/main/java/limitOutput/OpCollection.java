package limitOutput;

import java.util.Collection;

public class OpCollection implements Operable {

    @Override
    public <T> int getLength(T val) {
        return ((Collection) val).size();
    }

    @Override
    public void handleLine() {

    }
}
