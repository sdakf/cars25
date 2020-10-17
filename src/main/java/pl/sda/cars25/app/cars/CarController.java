package pl.sda.cars25.app.cars;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping //Tworzenie nowego zasobu
    public ResponseEntity<CarDTO> saveNewCar(@RequestBody CarDTO carDTO) {
        if (carDTO.getId() != null) {
            throw new CarException("To nie jest edycja!!!", HttpStatus.METHOD_NOT_ALLOWED);
        }
        CarDTO newCar = carService.createNew(carDTO);
        return ResponseEntity.status(201).body(newCar);
    }

    @PutMapping("/{id}") //Edycja zasobu
    public ResponseEntity<CarDTO> editCar(@RequestBody CarDTO carDTO, @PathVariable UUID id) {
        if (!carDTO.getId().equals(id)) {
            throw new CarException("Id się nie zgadza!!!", HttpStatus.NOT_ACCEPTABLE);
        }
        CarDTO updatedCar = carService.update(carDTO);
        return ResponseEntity.accepted().body(updatedCar);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CarDTO>> findByModel(@RequestParam String model) {
        List<CarDTO> byModel = carService.findByModel(model);
        return ResponseEntity.status(200).body(byModel);
    }


    @GetMapping
    public ResponseEntity<List<CarDTO>> findAllCars() {
        List<CarDTO> allCars = carService.findAllCars();
        return ResponseEntity.ok(allCars);
    }
}
