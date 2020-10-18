package pl.sda.cars25.app;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.cars25.app.cars.Car;
import pl.sda.cars25.app.cars.CarRepository;
import pl.sda.cars25.app.cars.Colour;
import pl.sda.cars25.app.users.User;
import pl.sda.cars25.app.users.UserRepository;
import pl.sda.cars25.app.users.UserRole;
import pl.sda.cars25.app.users.UserRoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataSeed implements InitializingBean {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final CarRepository carRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeed(UserRepository userRepository, UserRoleRepository userRoleRepository, CarRepository carRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.carRepository = carRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (userRoleRepository.count() == 0) {
            UserRole userRole = new UserRole(UserRole.ADMIN);
            UserRole userRole2 = new UserRole(UserRole.USER);
            userRoleRepository.save(userRole);
            userRoleRepository.save(userRole2);
        }
        if (carRepository.count() == 0) {
            for (int i = 0; i < 1000; i++) {
                Car car = new Car("Audi" + i, i % 2 == 0 ? Colour.BLACK : Colour.WHITE);
                carRepository.save(car);
            }
        }
        if (userRepository.count() == 0) {
            List<Car> cars = carRepository.findAll();

            createUser(UserRole.ADMIN, "a@a.pl", cars, 0);
            createUser(UserRole.USER, "b@b.pl", cars, 100);
            createUser(UserRole.USER, "c@c.pl", cars, 200);
            createUser(UserRole.USER, "d@d.pl", cars, 300);
            createUser(UserRole.USER, "e@e.pl", cars, 400);
        }
    }

    private void createUser(String roleName, String email, List<Car> cars, int skip) {
        List<Car> carsForUser = cars.stream().skip(skip).limit(100).collect(Collectors.toList());

        UserRole userRole = userRoleRepository.findByRoleName(roleName).orElseThrow(() -> new RuntimeException("Role not found"));
        User user = new User(
                "A",
                "A",
                email,
                passwordEncoder.encode("a"),
                List.of(userRole),
                carsForUser);
        userRepository.save(user);
    }
}
