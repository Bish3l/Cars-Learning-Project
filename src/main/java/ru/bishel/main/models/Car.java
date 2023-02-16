package ru.bishel.main.models;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private int id;
    private String name;
    private int maxSpeed;
    private int amountOfDoors;
    private int cost;

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
