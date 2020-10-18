package pl.sda.cars25.app.cars;

import pl.sda.cars25.app.BaseEntity;
import pl.sda.cars25.app.users.User;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Cars")
public class Car extends BaseEntity {

    private String model;

    @Enumerated(EnumType.STRING)
    private Colour colour;

    private Car(UUID id, Long version) {
        super(id, version);
    }

    public Car() {
    }

    public Car(String model, Colour colour) {
        this.model = model;
        this.colour = colour;
    }

    public CarDTO toDTO() {
        return new CarDTO(getId(), getVersion(), this.model, this.colour);
    }

    public void update(CarDTO carDTO) {
        if (carDTO.getModel() != null) {
            this.model = carDTO.getModel();
        }
        if (carDTO.getColour() != null) {
            this.colour = carDTO.getColour();
        }
    }

    public static Car apply(CarDTO carDTO) {
        //zabezpieczenie w przypadku tworzenia nowego samochodu (żeby ne przekazać null)
        Car car = carDTO.getId() == null ? new Car() : new Car(carDTO.getId(), carDTO.getVersion());
        car.colour = carDTO.getColour();
        car.model = carDTO.getModel();
        return car;
    }

    public String getModel() {
        return model;
    }

    public Colour getColour() {
        return colour;
    }
}
