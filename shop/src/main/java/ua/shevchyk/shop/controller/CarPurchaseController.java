package ua.shevchyk.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ua.shevchyk.shop.dto.CarDto;
import ua.shevchyk.shop.dto.UserDto;
import ua.shevchyk.shop.exception.CarPurchaseException;
import ua.shevchyk.shop.exception.InternalException;
import ua.shevchyk.shop.model.CarPurchaseContract;
import ua.shevchyk.shop.service.api.IShopService;
import ua.shevchyk.shop.service.impl.ShopServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class CarPurchaseController {

    private final IShopService shopService;

    public CarPurchaseController(IShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getAllCars() {
        try {
            List<CarDto> cars = shopService.getAllCars();
            return ResponseEntity.ok(cars);
        } catch (InternalException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/contracts")
    public ResponseEntity<List<CarPurchaseContract>> getAllContracts() {
        return ResponseEntity.ok(shopService.getAllContracts());
    }

    @PostMapping("/contracts")
    public ResponseEntity<CarPurchaseContract> purchaseCar(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(shopService.purchaseCar(userDto));
        } catch (CarPurchaseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
