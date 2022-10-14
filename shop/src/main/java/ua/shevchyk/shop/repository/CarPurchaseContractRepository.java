package ua.shevchyk.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.shevchyk.shop.model.CarPurchaseContract;

public interface CarPurchaseContractRepository extends JpaRepository<CarPurchaseContract, Long> {
}
