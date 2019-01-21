import org.afyahmis.hwr.domain.Designation;
import org.afyahmis.hwr.domain.Workforce;
import org.afyahmis.hwr.interfaces.DesignationRepository;
import org.afyahmis.hwr.interfaces.WorkforceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.UUID;

public class DesignationRepositoryImpl implements DesignationRepository {
    private SessionFactory sessionFactory;

    public DesignationRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void CreateOrUpdate(Designation entity) {
        Session session= this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Designation get(String id) {
        Session session = this.sessionFactory.openSession();
        Designation designation = session.get(Designation.class, id);
        session.close();
        return designation;
    }

    @Override
    public List<Designation> getAll() {
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder builder=session.getCriteriaBuilder();
        CriteriaQuery<Designation> criteriaQuery=builder.createQuery(Designation.class);
        criteriaQuery.from(Designation.class);
        List<Designation> designations = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return designations;
    }

    @Override
    public void Remove(String id) {
        Session session= this.sessionFactory.openSession();
        session.beginTransaction();
        Designation designation=get(id);
        session.delete(designation);
        session.getTransaction().commit();
        session.close();
    }
}
