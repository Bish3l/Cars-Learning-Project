package ru.bishel.main.dao;

import org.springframework.stereotype.Component;
import ru.bishel.main.models.Car;

import java.sql.*;
import java.util.*;

@Component
public class CarsDAO {
    private static int ID = 0;

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12344321";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM car";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Car car = new Car();

                car.setId(resultSet.getInt("id"));
                car.setAmountOfDoors(resultSet.getInt("amountOfDoors"));
                car.setCost(resultSet.getInt("cost"));
                car.setManufacturingYear(resultSet.getInt("manufacturingYear"));
                car.setName(resultSet.getString("name"));
                car.setMaxSpeed(resultSet.getInt("maxSpeed"));

                cars.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cars;
    }
    public void addCar(Car car) {
//        car.setId(ID++);
//        cars.add(car);

        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO car VALUES(" + 1 + ",'" + car.getName() + "'" + "," + car.getMaxSpeed() + "," + car.getAmountOfDoors() + ","
                    + car.getManufacturingYear() + "," + car.getCost() + ")";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
//        for (int i = 0; i < cars.size(); i++) {
//            if (cars.get(i).getId() == id) {
//                cars.remove(i);
//                return;
//            }
//        }
    }
    public Car getCar(int id) {
//        for (int i = 0; i < cars.size(); i++) {
//            if (cars.get(i).getId() == id) {
//                return cars.get(i);
//            }
//        }
//        return null;
        return null;
    }
}
