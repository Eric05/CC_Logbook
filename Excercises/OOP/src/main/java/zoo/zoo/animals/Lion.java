package zoo.zoo.animals;

import zoo.zoo.food.Food;
import zoo.zoo.food.LionFood;

public class Lion extends Animal {
    private Food food;

    public Lion(String name, String species) {
        super(name, species);
        this.food = new LionFood();
    }

    public Lion(String name, String species, Food lionFood) {
        super(name, species, lionFood);
    }
}
