import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HibernateUtilTest {


    @Test
    public void getSessionFactory() {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Assert.assertNotNull(sessionFactory);
        Session session=sessionFactory.openSession();
        Assert.assertTrue(session.isOpen());
    }
}