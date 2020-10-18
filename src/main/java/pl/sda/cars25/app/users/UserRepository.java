package pl.sda.cars25.app.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.cars25.app.cars.Car;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("select c from User u join u.cars c where c.model like concat( ?1,'%') and u.email = ?2")
    List<Car> findByModelAndUserEmail(String model, String userEmail);

}
