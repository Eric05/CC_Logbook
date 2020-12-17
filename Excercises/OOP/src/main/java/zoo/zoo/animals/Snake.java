package zoo.zoo.animals;

import zoo.zoo.food.Food;

public class Snake extends Animal {
    private Food food;

    public Snake(String name, String species) {
        super(name, species);
    }

    public Snake(String name, String species, Food snakeFood) {
        super(name, species, snakeFood);
    }
}