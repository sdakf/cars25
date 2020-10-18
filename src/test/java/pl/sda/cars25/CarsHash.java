package pl.sda.cars25;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CarsHash {

    @Test
    void hash() {
        Car c1 = new Car("Bmw");
        Car c2 = new Car("Audi");
        Car c3 = new Car("Bmw");
        Set<Car> hashSet = new HashSet<>();

        hashSet.add(c1);
        hashSet.add(c2);
        hashSet.add(c3);
        System.out.println(hashSet.size());
        System.out.println(hashSet);
    }

    private class Car {
        private String model;

        public Car(String model) {
            this.model = model;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return model.equals(car.model);
        }

        @Override
        public int hashCode() {
//            return Objects.hash(model);
            return 1;
        }
    }
}
