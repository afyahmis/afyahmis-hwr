package org.afyahmis.hwr.sharedkernel.interfaces;

import java.util.List;

public interface Repository<T,TId> {
    void createOrUpdate(T entity);
    T get(final TId id);
    List<T> getAll();
    void remove(TId id);
}
