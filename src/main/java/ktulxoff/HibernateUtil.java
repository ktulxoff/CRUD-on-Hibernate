package ktulxoff;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.HibernateException;

import java.io.File;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
	private static Session session = sessionFactory.openSession();

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactoryReturn = null;
        try {
            File file = new File("src\\main\\resources\\hibernate.cfg.xml");
            Configuration configuration = new Configuration().configure(file);
            sessionFactoryReturn = configuration.buildSessionFactory();
        }
        catch (NullPointerException ex) {ex.printStackTrace();}
        catch (HibernateException ex) {ex.printStackTrace();}
        return sessionFactoryReturn;

    }

	public static void startSession(){
		session.getTransaction().begin();
	}

	public static Session getSession(){
		return session;
	}
	
	public static void stopSession(){
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}