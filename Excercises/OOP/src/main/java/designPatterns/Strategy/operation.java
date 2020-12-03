package designPatterns.Strategy;

public class operation {
    private numberStrategy strategy;

    public operation(numberStrategy strategy){
        this.strategy = strategy;
    }
    public int executeStrategy(int a, int b){
        return strategy.doOperation(a, b);
    }
}
