package dataBases;

import comparator_Comparable.Man;
import comparator_Comparable.PlayerNameLengthComparator;
import dataBases.daos.FoodDao_MySqlImpl;
import dataBases.models.Food;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        var dao = new FoodDao_MySqlImpl();

        var foods = dao.getAllFoods();
        printFoodsSortedByName(foods);
        System.out.println("----");
        printFoods(foods);
    }

    // view
  public static void  printFoods(List<Food> foods){

      for (Food food : foods) {
          System.out.println(food.getId()+ " | " +  food.getName() );
      }
  }
    public static void  printFoodsSortedByName(List<Food> foods){
        var sorted = foods.stream()
                .sorted(new Food.FoodByNameComparator())
                .collect(Collectors.toList());
        for (Food food : sorted) {
            System.out.println(food.getId()+ " | " +  food.getName() );
        }
    }

    // using method reference instead of Comparator class
    public static void  printFoodsSortedById(List<Food> foods){
        var sorted = foods.stream()
                .sorted(Comparator.comparing(Food::getId))
                .collect(Collectors.toList());
        for (Food food : sorted) {
            System.out.println(food.getId()+ " | " +  food.getName() );
        }
    }

}
