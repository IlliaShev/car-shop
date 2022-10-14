package ua.shevchyk.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.shevchyk.carservice.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
