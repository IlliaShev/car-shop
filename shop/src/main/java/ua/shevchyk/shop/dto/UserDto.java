package ua.shevchyk.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private String name;
    private String surname;
    private Long carId;

}
