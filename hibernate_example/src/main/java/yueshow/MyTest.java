package yueshow;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

public class MyTest {

    private static SessionFactory sf;

    @BeforeClass
    public static void setUp() {
        Configuration cfg = new Configuration();
        sf = cfg.configure().buildSessionFactory();
    }

    @Test
    public void test666() throws InterruptedException {
        for (int i = 3; i <100; i++) {
            Thread.sleep(15000);
            testAdd(i);
        }

    }

    public void testAdd(int t) {
        MyEntity myEntity = new MyEntity();
        myEntity.setId(t);
        myEntity.setUsername("小丽" + t);
        myEntity.setMyfield(new Date());

        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(myEntity);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
