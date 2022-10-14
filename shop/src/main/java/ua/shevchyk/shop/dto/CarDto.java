package ua.shevchyk.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private double price;
}
