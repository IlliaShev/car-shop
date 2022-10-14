package ua.shevchyk.shop.service.api;

import ua.shevchyk.shop.dto.CarDto;
import ua.shevchyk.shop.dto.UserDto;
import ua.shevchyk.shop.model.CarPurchaseContract;

import java.util.List;

public interface IShopService {

    CarPurchaseContract purchaseCar(UserDto user);
    List<CarPurchaseContract> getAllContracts();
    List<CarDto> getAllCars();

}
