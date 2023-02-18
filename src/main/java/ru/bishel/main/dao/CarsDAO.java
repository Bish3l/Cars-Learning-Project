package ru.bishel.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bishel.main.models.Car;

import java.sql.*;
import java.util.*;

@Component
public class CarsDAO {
    private static int ID = 0;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> getCars() {

        return jdbcTemplate.query("SELECT * FROM car", new CarsMapper());
    }
    public void addCar(Car car) {
        jdbcTemplate.update("INSERT INTO car(name, maxSpeed, amountOfDoors, manufacturingYear, cost) VALUES(?, ?, ?, ?, ?)", car.getName(), car.getMaxSpeed(), car.getAmountOfDoors(), car.getManufacturingYear(), car.getCost());
    }
    public void editCar(Car car, int id) {
        jdbcTemplate.update("UPDATE car SET name=?, maxSpeed=?, amountOfDoors=?, manufacturingYear=?, cost=? WHERE id=?",
                car.getName(), car.getMaxSpeed(), car.getAmountOfDoors(), car.getManufacturingYear(), car.getCost(), id);
    }
    public void deleteCar(int id) {
        jdbcTemplate.update("DELETE FROM car WHERE id=?", id);
    }
    public Car getCar(int id) {
        return jdbcTemplate.query("SELECT * FROM car WHERE id=?", new Object[]{id}, new CarsMapper())
                .stream().findAny().orElse(null);
    }
}
