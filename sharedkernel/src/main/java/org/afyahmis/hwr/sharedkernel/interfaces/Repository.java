package org.afyahmis.hwr.sharedkernel.interfaces;

import java.util.List;

public interface Repository<T,TId> {
    void CreateOrUpdate(T entity);
    T get(TId id);
    List<T> getAll();
    void Remove(TId id);
}
