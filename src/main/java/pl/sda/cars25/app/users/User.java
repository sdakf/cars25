package pl.sda.cars25.app.users;

import pl.sda.cars25.app.BaseEntity;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {

    private String firstName;
    private String surname;
    private String email;
}
