package pl.sda.cars25;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public CarDTO saveNewCar(@RequestBody CarDTO carDTO) {
        return carService.saveCar(carDTO);
    }

    @GetMapping
    public List<CarDTO> findAllCars(){
        return carService.findAllCars();
    }
}
