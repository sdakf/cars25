package pl.sda.cars25.app.cars;

import pl.sda.cars25.app.cars.CarRepository;

public class AnotherCarService {

    private CarRepository carRepository;

    public AnotherCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
