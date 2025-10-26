package ru.javabegin.micro.demo.model;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private List<PuckupPoint> pickupPoints;

    public Product(int id, String name, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.name = name;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<PuckupPoint> getPickupPoints() {
        return pickupPoints;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPickupPoints(List<PuckupPoint> pickupPoints) {
        this.pickupPoints = pickupPoints;
    }
}
