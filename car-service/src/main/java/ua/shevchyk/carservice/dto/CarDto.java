package ua.shevchyk.carservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    private String brand;
    private String model;
    private int year;
    private double price;

}
