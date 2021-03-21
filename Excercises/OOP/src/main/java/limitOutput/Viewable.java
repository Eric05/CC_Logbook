package limitOutput;

public interface Viewable {

    <T> void  handleLine(T line, int buffer, int idx);
}
