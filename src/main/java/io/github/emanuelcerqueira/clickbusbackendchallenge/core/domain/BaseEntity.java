package io.github.emanuelcerqueira.clickbusbackendchallenge.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull
    @Id
    @Column(name = "id", length = 16, unique = true, updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();
    @Embedded
    private Audit audit = new Audit();

    @Version
    private Long version;

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
