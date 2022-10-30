package ua.shevchyk.carservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ua.shevchyk.carservice.dto.CarDto;
import ua.shevchyk.carservice.model.Car;
import ua.shevchyk.carservice.service.api.ICarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class CarController {

    private final ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        }
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Unable to find car with id - " + id);
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> addCar(@RequestBody CarDto carDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carService.addCar(carDto));
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Long> removeCar(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        if (car.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to delete car with id " + id + ", " +
                    "because car with such id does not exist");
        }
        carService.deleteCar(id);
        return ResponseEntity.ok(id);
    }

}
