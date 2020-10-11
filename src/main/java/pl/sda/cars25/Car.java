package pl.sda.cars25;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Entity
public class Car extends BaseEntity {

    private String model;

    @Enumerated(EnumType.STRING)
    private Colour colour;

    private Car(UUID id, Long version) {
        super(id, version);
    }

    public Car() {
    }

    public CarDTO toDTO() {
        return new CarDTO(getId(), getVersion(), this.model, this.colour);
    }

    public void update(CarDTO carDTO) {
        this.colour = carDTO.getColour();
        this.model = carDTO.getModel();
    }

    public static Car apply(CarDTO carDTO) {
        //zabezpieczenie w przypadku tworzenia nowego samochodu (żeby ne przekazać null)
        Car car = carDTO.getId() == null ? new Car() : new Car(carDTO.getId(), carDTO.getVersion());
        car.colour = carDTO.getColour();
        car.model = carDTO.getModel();
        return car;
    }
}
