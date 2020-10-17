package pl.sda.cars25.app.cars;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.sda.cars25.app.cars.Car;
import pl.sda.cars25.app.cars.CarDTO;
import pl.sda.cars25.app.cars.CarException;
import pl.sda.cars25.app.cars.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarDTO update(CarDTO carDTO) {
        Car car = carRepository.findById(carDTO.getId())
                .orElseThrow(() -> new CarException("nie znaleziono samochodu o ID: " + carDTO.getId(), HttpStatus.NOT_FOUND));
        car.update(carDTO);
        Car save = carRepository.save(car);
        return save.toDTO();
    }

    public CarDTO createNew(CarDTO carDTO) {
        Car car = Car.apply(carDTO);
        Car saved = carRepository.save(car);
        return saved.toDTO();
    }

    public List<CarDTO> findAllCars() {
        return carRepository.findAll()
                .stream()
                .map(car -> car.toDTO())
                .collect(Collectors.toList());
    }

    public List<CarDTO> findByModel(String model) {
        return carRepository.findByModelLike(model)
                .stream()
                .map(car -> car.toDTO())
                .collect(Collectors.toList());
    }
}
