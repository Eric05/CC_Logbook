package dataBases.models;

import java.util.Comparator;

public class Food {
    private int id;
    private String name;

    public Food(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public static class FoodByIDComparator implements Comparator<Food> {
        @Override
        public int compare(Food f1, Food f2) {
            return Integer.compare(f1.getId(), f2.getId());
        }
    }

    public static class FoodByNameComparator implements Comparator<Food> {
        @Override
        public int compare(Food f1, Food f2) {
            return f1.getName().compareTo(f2.getName());
        }
    }
}
