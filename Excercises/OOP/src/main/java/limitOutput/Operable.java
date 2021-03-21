package limitOutput;

public interface Operable {
    <T> int getLength(T val);
    void handleLine();
}
