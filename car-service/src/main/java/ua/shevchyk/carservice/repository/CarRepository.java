package ua.shevchyk.carservice.repository;

import org.springframework.stereotype.Repository;
import ua.shevchyk.carservice.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {

    List<Car> carRepository = new ArrayList<>(){{
        add(new Car("BMW", "X3", 2005, 10500));
        add(new Car("BMW", "X5", 2015, 11500));
        add(new Car("BMW", "X6", 2022, 12500));
        add(new Car("Mazda", "CX-30", 2016, 9500));
        add(new Car("Mazda", "CX-5", 2005, 13500));
    }};

    public List<Car> findAll() {
        return carRepository;
    }

    public Car save(Car car) {
        carRepository.add(car);
        return car;
    }

    public void deleteById(Long id) {
        Optional<Car> car = carRepository.stream().filter(car1 -> car1.getId().equals(id)).findFirst();
        car.ifPresent(value -> carRepository.remove(value));
    }

    public Optional<Car> findById(Long id) {
        return carRepository.stream().filter(car1 -> car1.getId().equals(id)).findFirst();
    }

}
