package ua.shevchyk.shop.repository;

import org.springframework.stereotype.Repository;
import ua.shevchyk.shop.model.CarPurchaseContract;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarPurchaseContractRepository {

    private List<CarPurchaseContract> carPurchaseContractRepository = new ArrayList<>();

    public List<CarPurchaseContract> findAll() {
        return carPurchaseContractRepository;
    }

    public CarPurchaseContract save(CarPurchaseContract carPurchaseContract) {
        carPurchaseContractRepository.add(carPurchaseContract);
        return carPurchaseContract;
    }

}
