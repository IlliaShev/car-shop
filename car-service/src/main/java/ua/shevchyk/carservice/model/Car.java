package ua.shevchyk.carservice.model;

import lombok.Getter;
import lombok.Setter;

public class Car {

    private static Long cnt = 0L;

    private Long id;

    private String brand;
    private String model;
    private int year;
    private double price;

    public Car(String brand, String model, int year, double price) {
        this.id = cnt++;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}
