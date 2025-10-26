package ru.javabegin.micro.demo.model;

public class PuckupPoint {
    private int id;
    private String city;
    private String address;

    public PuckupPoint(int id, String city, String address) {
        this.id = id;
        this.city = city;
        this.address = address;
    }

    public PuckupPoint() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
