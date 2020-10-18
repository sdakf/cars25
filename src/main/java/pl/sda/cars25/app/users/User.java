package pl.sda.cars25.app.users;

import pl.sda.cars25.app.BaseEntity;
import pl.sda.cars25.app.cars.Car;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends BaseEntity {

    private String firstName;
    private String surname;
    private String email;
    private String password;
    @ManyToMany
    private List<UserRole> roles;
    @OneToMany
    private List<Car> cars;

    public User(String firstName, String surname, String email, String password, List<UserRole> roles, List<Car> cars) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.cars = cars;
    }

    public User() {
    }
}
