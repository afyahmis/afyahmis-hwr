package org.afyahmis.hwr.infrastructure.data;

import org.afyahmis.hwr.domain.Workforce;
import org.afyahmis.hwr.interfaces.WorkforceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.UUID;

public class WorkforceRepositoryImpl implements WorkforceRepository {
    private SessionFactory sessionFactory;

    public WorkforceRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createOrUpdate(Workforce entity) {
        Session session= this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Workforce get(UUID id) {
        Session session = this.sessionFactory.openSession();
        Workforce workforce = session.get(Workforce.class, id);
        session.close();
        return workforce;
    }

    @Override
    public List<Workforce> getAll() {
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Workforce> criteriaQuery=builder.createQuery(Workforce.class);
        criteriaQuery.from(Workforce.class);
        List<Workforce> workforces = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return workforces;
    }

    @Override
    public void remove(UUID id) {
        Session session= this.sessionFactory.openSession();
        session.beginTransaction();
        Workforce workforce=get(id);
        session.delete(workforce);
        session.getTransaction().commit();
        session.close();
    }
}
