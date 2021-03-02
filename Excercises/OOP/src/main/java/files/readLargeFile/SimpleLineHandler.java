package files.readLargeFile;

import java.util.ArrayList;
import java.util.List;

public class SimpleLineHandler implements LargeFileReader.Linehandable {
    private final List<String> list = new ArrayList<>();

    @Override
    public void handleLine(String line) {
        if (isValidLine(line)) {
            System.out.println(line + "------");
            list.add(line);
        }
    }

    private boolean isValidLine(String line) {
        return line != null && !line.isBlank();
    }

    public List<String> getList() {
        return list;
    }
}
