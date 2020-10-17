package pl.sda.cars25.app.cars;

import java.util.UUID;

public class CarDTO {
    private UUID id; //to będzie puste dla nowego samochodu
    private Long version;//to też będzie puste dla nowego samochodu
    private String model;
    private Colour colour;

    public CarDTO(UUID id, Long version, String model, Colour colour) {
        this.id = id;
        this.version = version;
        this.model = model;
        this.colour = colour;
    }

    public UUID getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Colour getColour() {
        return colour;
    }

    public Long getVersion() {
        return version;
    }
}
