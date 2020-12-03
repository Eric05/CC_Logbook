package designPatterns;

public class Singleton {

    // instance of SingleObject
    private static Singleton instance = new Singleton();

    // important -> private Constructor
    private Singleton(){}

    //Get the only object available
    public static Singleton getInstance(){
        return instance;
    }

    public void showMessage() {
        System.out.println("I am the one and only");
    }
}

