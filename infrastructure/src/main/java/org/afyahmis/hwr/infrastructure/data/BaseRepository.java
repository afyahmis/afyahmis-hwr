package org.afyahmis.hwr.infrastructure.data;

import org.afyahmis.hwr.domain.Designation;
import org.afyahmis.hwr.sharedkernel.domain.AggregateRoot;
import org.afyahmis.hwr.sharedkernel.interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseRepository<T extends AggregateRoot, TId> implements Repository<T, TId> {
    private SessionFactory sessionFactory;

    protected BaseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createOrUpdate(T entity) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public T get(TId id) {
//        Session session = this.sessionFactory.openSession();
//        T entity = session.get(typeOf(), (Serializable) id);
//        session.close();
//        return designation;
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public void remove(TId tId) {

    }

    private Class<? extends T> typeOf() {
        Class<? extends T> typeOfT;
        typeOfT = (Class<T>)
                ((ParameterizedType) getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
        return typeOfT;
    }


}
