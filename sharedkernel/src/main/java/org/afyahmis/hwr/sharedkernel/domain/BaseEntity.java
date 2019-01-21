package org.afyahmis.hwr.sharedkernel.domain;
import org.afyahmis.hwr.sharedkernel.utils.LiveGuid;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.ParameterizedType;
import java.util.Objects;
import java.util.UUID;

@Entity
public abstract class BaseEntity<TId> {

    @Id
    protected TId id;

    public TId getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    protected BaseEntity() {
        if (isUUID())
            id = (TId) LiveGuid.NewId();
    }

    protected BaseEntity(TId id) {
        this.id = id;
    }

    private boolean isUUID(){
        Class<? extends TId> typeOfTId;
        typeOfTId = (Class<TId>)
                ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
        return UUID.class.isAssignableFrom(typeOfTId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity<?> baseEntity = (BaseEntity<?>) o;
        return Objects.equals(getId(), baseEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
