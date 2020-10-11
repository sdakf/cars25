package pl.sda.cars25;

import java.util.UUID;

public class CarDTO {
    private UUID id;
    private Long version;
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
