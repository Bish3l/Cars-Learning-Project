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

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO car VALUES(1, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, car.getName());
            preparedStatement.setInt(2, car.getMaxSpeed());
            preparedStatement.setInt(3, car.getAmountOfDoors());
            preparedStatement.setInt(4, car.getManufacturingYear());
            preparedStatement.setInt(5, car.getCost());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void editCar(Car car, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE car SET name=?, manufacturingYear=?," +
                    " cost=?, maxSpeed=?, amountOfDoors=? WHERE id=?");

            preparedStatement.setString(1, car.getName());
            preparedStatement.setInt(2, car.getManufacturingYear());
            preparedStatement.setInt(3, car.getCost());
            preparedStatement.setInt(4, car.getMaxSpeed());
            preparedStatement.setInt(5, car.getAmountOfDoors());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteCar(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM car WHERE id=?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Car getCar(int id) {
        Car car = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM car WHERE id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            car = new Car();

            car.setId(resultSet.getInt("id"));
            car.setMaxSpeed(resultSet.getInt("maxSpeed"));
            car.setName(resultSet.getString("name"));
            car.setAmountOfDoors(resultSet.getInt("amountOfDoors"));
            car.setManufacturingYear(resultSet.getInt("manufacturingYear"));
            car.setCost(resultSet.getInt("cost"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return car;
    }
}
