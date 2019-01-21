import org.afyahmis.hwr.infrastructure.data.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

public class HibernateUtilTest {


    @Test
    public void getSessionFactory() {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Assert.assertNotNull(sessionFactory);
        Session session=sessionFactory.openSession();
        Assert.assertTrue(session.isOpen());
    }
}