import junit.framework.TestCase;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 * test hibernate configuration
 * @author qutong
 *
 */
public class HibernateTest extends TestCase {
	// test API ,configuration,sessionfactory,session and transaction
	public void test1() {
		// parse hibernate.cfg.xml
		Configuration cfg = new Configuration().configure();
		// create SessionFactory (connections pool)
		SessionFactory factory = cfg.buildSessionFactory();
		// create session core api include search update insert delete/..
		Session session = factory.openSession();
		// create and active event
		Transaction trans = null;
		//following work can be done by spring
		try {
			trans = session.beginTransaction();
			session.save("this can be an objetc like users");
			trans.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			trans.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

	}
}
