package pl.sda.cars25.app.cars;

import org.springframework.http.HttpStatus;

public class CarException extends RuntimeException{

    private HttpStatus httpStatus;

    public CarException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
