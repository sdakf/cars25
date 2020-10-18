package pl.sda.cars25.app.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
//    void findByRoleName(String admin);

    @Query("select ur from UserRole ur where ur.roleName=:roleName")
    Optional<UserRole> findByRoleName(@Param("roleName") String roleName);
}
