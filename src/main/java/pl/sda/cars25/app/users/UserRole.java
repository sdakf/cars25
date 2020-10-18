package pl.sda.cars25.app.users;

import pl.sda.cars25.app.BaseEntity;

import javax.persistence.Entity;

@Entity
public class UserRole extends BaseEntity {
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    private String roleName;

    public UserRole(String roleName) {
        this.roleName = roleName;
    }
    public UserRole() {}
}
