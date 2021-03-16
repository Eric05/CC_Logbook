package dataBases.daos;

import dataBases.models.Food;

import java.util.List;

public interface FoodDao {
    List<Food> getAllFoods();
}
