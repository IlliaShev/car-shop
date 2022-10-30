package ua.shevchyk.carservice.service.impl;

import org.springframework.stereotype.Service;
import ua.shevchyk.carservice.dto.CarDto;
import ua.shevchyk.carservice.model.Car;
import ua.shevchyk.carservice.repository.CarRepository;
import ua.shevchyk.carservice.service.api.ICarService;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Long carId) {
        return carRepository.findById(carId);
    }

    @Override
    public Car addCar(CarDto carDto) {
        Car car = new Car(
                carDto.getBrand(),
                carDto.getModel(),
                carDto.getYear(),
                carDto.getPrice()
        );
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
