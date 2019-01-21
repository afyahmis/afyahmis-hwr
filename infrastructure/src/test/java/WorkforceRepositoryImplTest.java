import org.afyahmis.hwr.infrastructure.data.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorkforceRepositoryImplTest {

   private  SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Test
    public void createOrUpdate() {

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
    }
}