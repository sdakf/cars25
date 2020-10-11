package pl.sda.cars25;

import org.hibernate.annotations.Type;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {

    @Id
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();

    @Version
    private Long version;

    protected BaseEntity(UUID id, Long version) {
        this.id = id;
        this.version = version;
    }

    public BaseEntity() {
    }

    public UUID getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }
}
