package zoo.zoo.data;

import zoo.zoo.food.Food;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFoodlist {
    public static Map<String, Food> foodlist = new HashMap<>();

    public static void addToFoodlist(String name, Food food){
        foodlist.put(name,food);
    }
}
