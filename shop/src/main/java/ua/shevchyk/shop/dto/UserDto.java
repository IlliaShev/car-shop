package ua.shevchyk.shop.dto;

public class UserDto {

    private String name;
    private String surname;
    private Long carId;

    public UserDto() {
    }

    public UserDto(String name, String surname, Long carId) {
        this.name = name;
        this.surname = surname;
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
}
