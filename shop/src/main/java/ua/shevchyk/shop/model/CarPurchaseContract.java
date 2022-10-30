package ua.shevchyk.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class CarPurchaseContract {
    private static Long cnt = 0L;

    private Long id;

    private String name;
    private String surname;

    private String brand;
    private String model;
    private Date date;

    public CarPurchaseContract(String name, String surname, String brand, String model, Date date) {
        this.id = cnt++;
        this.name = name;
        this.surname = surname;
        this.brand = brand;
        this.model = model;
        this.date = date;
    }
}
