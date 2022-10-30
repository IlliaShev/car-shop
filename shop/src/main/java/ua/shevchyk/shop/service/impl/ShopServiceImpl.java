package ua.shevchyk.shop.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.shevchyk.shop.dto.CarDto;
import ua.shevchyk.shop.dto.UserDto;
import ua.shevchyk.shop.exception.CarPurchaseException;
import ua.shevchyk.shop.exception.InternalException;
import ua.shevchyk.shop.model.CarPurchaseContract;
import ua.shevchyk.shop.repository.CarPurchaseContractRepository;
import ua.shevchyk.shop.service.api.IShopService;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ShopServiceImpl implements IShopService {

    private final CarPurchaseContractRepository contractRepository;
    private final RestTemplate restTemplate;

    public ShopServiceImpl(CarPurchaseContractRepository contractRepository, RestTemplate restTemplate) {
        this.contractRepository = contractRepository;
        this.restTemplate = restTemplate;
    }

    @Value("${car.service.url}")
    private String BASE_URL;

    @Override
    public CarPurchaseContract purchaseCar(UserDto user) {
        Long carId = user.getCarId();
        ResponseEntity<CarDto> responseCar = restTemplate.getForEntity(BASE_URL + "/api/v1/cars/" + carId, CarDto.class);
        CarDto carDto = responseCar.getBody();
        if (!responseCar.getStatusCode().is2xxSuccessful() || Objects.isNull(carDto)) {
            throw new CarPurchaseException("Couldn`t get car with id " + carId);
        }

        CarPurchaseContract carPurchaseContract = new CarPurchaseContract(
                user.getName(),
                user.getSurname(),
                carDto.getBrand(),
                carDto.getModel(),
                new Date()
        );

        CarPurchaseContract savedContract = contractRepository.save(carPurchaseContract);

        ResponseEntity<Long> idOfDeletedCar = restTemplate.exchange(BASE_URL + "/api/v1/cars/" + carId, HttpMethod.DELETE, null, Long.class);
        if (!idOfDeletedCar.getStatusCode().is2xxSuccessful()) {
            throw new CarPurchaseException("Exception occurred while purchasing car with id " + carId);
        }

        return savedContract;
    }

    @Override
    public List<CarPurchaseContract> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public List<CarDto> getAllCars() {
        ResponseEntity<CarDto[]> responseCars = restTemplate.getForEntity(BASE_URL + "/api/v1/cars", CarDto[].class);
        if (!responseCars.getStatusCode().is2xxSuccessful()) {
            throw new InternalException("Couldn`t get cars from car-service");
        }
        return List.of(Objects.requireNonNull(responseCars.getBody()));
    }
}
