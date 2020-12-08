package designPatterns.strategy;

public class multiplication implements numberStrategy {
    @Override
    public int doOperation(int a, int b) {
        return a * b;
    }
}
