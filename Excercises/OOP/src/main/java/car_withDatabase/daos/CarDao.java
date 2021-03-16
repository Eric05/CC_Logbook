package car_withDatabase.daos;

import car_withDatabase.models.Car;

import java.util.List;

public interface CarDao {
    List<Car> getAllCars();
}
