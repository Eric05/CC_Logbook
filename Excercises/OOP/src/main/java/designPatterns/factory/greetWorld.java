package designPatterns.factory;

public class greetWorld implements greet {
    @Override
    public void greet() {
        System.out.println("hello world");
    }
}
