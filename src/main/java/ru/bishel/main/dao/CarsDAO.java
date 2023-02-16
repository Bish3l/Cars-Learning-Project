package ru.bishel.main.dao;

import org.springframework.stereotype.Component;
import ru.bishel.main.models.Car;

import java.util.*;

@Component
public class CarsDAO {
    private static int ID = 0;
    List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(ID++,"Lamborghini Aventador", 400, 2, 200000, 2019));
        cars.add(new Car(ID++,"BMW X5", 230, 4, 40000, 2014));
        cars.add(new Car(ID++,"Toyota Corolla", 170, 4, 10000, 2007));
        cars.add(new Car(ID++,"Mercedes AMG GT Roadster", 370, 2, 97500, 2020));
    }

    public List<Car> getCars() {
        return cars;
    }
    public void addCar(Car car) {
        car.setId(ID++);
        cars.add(car);
    }
    public void editCar(Car car, int id) {
        Car existingCar = getCar(id);

        existingCar.setCost(car.getCost());
        existingCar.setName(car.getName());
        existingCar.setAmountOfDoors(car.getAmountOfDoors());
        existingCar.setMaxSpeed(car.getMaxSpeed());
        existingCar.setManufacturingYear(car.getManufacturingYear());
    }
    public void deleteCar(int id) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == id) {
                cars.remove(i);
                return;
            }
        }
    }
    public Car getCar(int id) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == id) {
                return cars.get(i);
            }
        }
        return null;
    }
}
