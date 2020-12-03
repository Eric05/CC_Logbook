package designPatterns.Factory;

public class greetFactory {

    public greet getGreetType(String greetType){
        if(greetType.equalsIgnoreCase("all")){
            return new greetWorld();
        } else {
            return new greetMom();
        }
    }
}
