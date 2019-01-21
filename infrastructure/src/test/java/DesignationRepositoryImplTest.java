import com.github.javafaker.Faker;
import org.afyahmis.hwr.domain.Designation;
import org.afyahmis.hwr.interfaces.DesignationRepository;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
    }

    @Test
    public void createOrUpdate() {
        designationRepository.CreateOrUpdate(designations.get(0));
        Designation newDesignation=sessionFactory.openSession().get(Designation.class,designations.get(0).getId());
        Assert.assertNotNull(newDesignation);
        System.out.println(newDesignation);
    }

    @Test
    public void get() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void remove() {
    }

    @After
    public void tearDown() throws Exception {
        sessionFactory.getCurrentSession().close();
    }

}