package designPatterns.template;

public abstract class Game {

    public final void play() {
        greet();
        playGame();
        goodbye();
    }

    protected void greet() {
        System.out.println("hello world");
    }

    protected void goodbye() {
        System.out.println("thanks for joining us");
    }

    abstract void playGame();
}
