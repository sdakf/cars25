package pl.sda.cars25;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {

    private String firstName;
    private String surname;
    private String email;
}
