package ru.bishel.main.dao;


import org.springframework.jdbc.core.RowMapper;
import ru.bishel.main.models.Car;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarsMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();

        car.setId(resultSet.getInt("id"));
        car.setAmountOfDoors(resultSet.getInt("amountOfDoors"));
        car.setCost(resultSet.getInt("cost"));
        car.setManufacturingYear(resultSet.getInt("manufacturingYear"));
        car.setName(resultSet.getString("name"));
        car.setMaxSpeed(resultSet.getInt("maxSpeed"));

        return car;
    }
}
