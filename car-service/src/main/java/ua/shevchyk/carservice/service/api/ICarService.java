package ua.shevchyk.carservice.service.api;

import ua.shevchyk.carservice.dto.CarDto;
import ua.shevchyk.carservice.model.Car;

import java.util.List;
import java.util.Optional;

public interface ICarService {

    List<Car> getAllCars();
    Optional<Car> getCarById(Long carId);
    Car addCar(CarDto carDto);
    void deleteCar(Long carId);
}
