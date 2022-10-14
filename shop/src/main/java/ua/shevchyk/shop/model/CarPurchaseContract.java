package ua.shevchyk.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car_purchase_contract")
@NoArgsConstructor
@Getter
@Setter
public class CarPurchaseContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    private String brand;
    private String model;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public CarPurchaseContract(String name, String surname, String brand, String model, Date date) {
        this.name = name;
        this.surname = surname;
        this.brand = brand;
        this.model = model;
        this.date = date;
    }
}
