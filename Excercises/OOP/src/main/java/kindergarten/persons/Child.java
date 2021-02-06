package kindergarten.persons;

import kindergarten.Game;

public class Child extends Person {

    private int happiness = 7;

    public Child(String name) {
        super(name);
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void play(Game game) {
        System.out.println(" + " + this.getName() + " plays " + game.toString());
        this.setHappiness(this.getHappiness() + 1);
    }
}
