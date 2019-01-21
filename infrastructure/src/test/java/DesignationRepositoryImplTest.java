import com.github.javafaker.Faker;
import org.afyahmis.hwr.domain.Designation;
import org.afyahmis.hwr.infrastructure.data.DesignationRepositoryImpl;
import org.afyahmis.hwr.infrastructure.data.HibernateUtil;
import org.afyahmis.hwr.interfaces.DesignationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DesignationRepositoryImplTest {

    private SessionFactory sessionFactory;
    private List<Designation> designations = new ArrayList<>();
    private DesignationRepository designationRepository;

    @Before
    public void setUp() throws Exception {
        sessionFactory = HibernateUtil.getSessionFactory();
        designationRepository = new DesignationRepositoryImpl(sessionFactory);
        Faker faker = new Faker();
        designations.add(new Designation(faker.company().name(), faker.company().profession()));
        designations.add(new Designation(faker.company().name(), faker.company().profession()));
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        for (Designation d:designations) {
            session.save(d);
        }
        session.getTransaction().commit();
    }

    @Test
    public void createOrUpdate() {
        Designation designation =new Designation("Doc", "Doctor");
        designationRepository.createOrUpdate(designation);
        Designation newDesignation = sessionFactory.openSession().get(Designation.class, designation.getId());
        Assert.assertNotNull(newDesignation);
        System.out.println(newDesignation);
    }

    @Test
    public void get() {
        Designation designation = designationRepository.get(designations.get(0).getId());
        Assert.assertNotNull(designation);
        System.out.println(designation);
    }

    @Test
    public void getAll() {
        List<Designation> designations = designationRepository.getAll();
        Assert.assertTrue(designations.size()>0);
    }

    @Test
    public void remove() {
        designationRepository.remove(designations.get(0).getId());
        Designation designation = designationRepository.get(designations.get(0).getId());
        Assert.assertNull(designation);
    }

    @After
    public void tearDown() throws Exception {
        sessionFactory.getCurrentSession().close();
    }

}