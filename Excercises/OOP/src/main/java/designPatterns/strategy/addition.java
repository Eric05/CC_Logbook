package designPatterns.strategy;

public class addition implements numberStrategy {
    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}
