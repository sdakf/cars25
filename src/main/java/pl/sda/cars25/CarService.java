package pl.sda.cars25;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarDTO update(CarDTO carDTO) {
        Car car = carRepository.findById(carDTO.getId()).orElse(null);
        car.update(carDTO);
        Car save = carRepository.save(car);
        return save.toDTO();
    }

    public CarDTO saveCar(CarDTO carDTO){
        Car car = Car.apply(carDTO);
        Car saved = carRepository.save(car);
        return saved.toDTO();
    }

    public List<CarDTO> findAllCars(){
        return carRepository.findAll()
                .stream()
                .map(car -> car.toDTO())
                .collect(Collectors.toList());
    }
}
