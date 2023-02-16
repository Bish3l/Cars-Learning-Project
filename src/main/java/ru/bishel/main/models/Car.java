package ru.bishel.main.models;


import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class Car {
    private int id;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 2, max = 40, message = "Name must be more than 1 and less than 41 characters")
    private String name;

    @Min(value = 10, message = "Maximum speed cannot be less than 10 km/h")
    @Max(value = 10000, message = "Maximum speed cannot be greater than 10 000 km/h")
    private int maxSpeed;

    @Min(value = 2, message = "You cannot have less than 2 doors")
    @Max(value = 14, message = "You cannot have more than 14 doors")
    private int amountOfDoors;

    @Min(value = 0, message = "Cost can't be negative")
    private int cost;
    @Min(value = 0, message = "Year of manufacturing can't be negative")
    private int manufacturingYear;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getAmountOfDoors() {
        return amountOfDoors;
    }

    public void setAmountOfDoors(int amountOfDoors) {
        this.amountOfDoors = amountOfDoors;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public Car() {

    }

    public Car(int id, String name, int maxSpeed, int amountOfDoors, int cost, int manufacturingYear) {
        this.id = id;
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.amountOfDoors = amountOfDoors;
        this.cost = cost;
        this.manufacturingYear = manufacturingYear;
    }
}
