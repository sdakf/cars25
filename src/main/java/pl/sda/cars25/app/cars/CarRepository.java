package pl.sda.cars25.app.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.cars25.app.cars.Car;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
//    Collection<Object> findByModel(String model);

    @Query("SELECT c FROM Car c WHERE upper(c.model) LIKE upper(concat(?1,'%'))") //jpql hql
    List<Car> findByModelLike(String model);
}
