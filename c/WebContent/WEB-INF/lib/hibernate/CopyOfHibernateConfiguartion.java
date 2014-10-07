package hibernate;

import java.util.Properties;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class CopyOfHibernateConfiguartion {
	public static SessionFactory sessionFactory ;
	
	
	/**
	 * 
	 * 
	 * @throws NamingException
	 * Method's scope should be finding the number of connections used at a time. Call to this static method should provide the 
	 * number of active connections to the intended database.
	 */
	public static void queryPool() throws NamingException{
		Properties props = new Properties();
	    props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
	    props.setProperty(javax.naming.Context.URL_PKG_PREFIXES, "jdbc");
	    //props.setProperty(Context.PROVIDER_URL,"oracle.aurora.jndi:mysql://localhost:3306/mysql");
	    Context ctx = new InitialContext(props);
	    InitialContext ictx = new InitialContext(props);
	     // get the initial context
		//InitialContext ictx = new InitialContext(); 
		DataSource ds = (DataSource) ctx.lookupLink( "jdbc:mysql://localhost:3306/mysql" ); // make sure it's a c3p0 PooledDataSource
		System.out.println( " ds ____------- " + ds);
		/*if ( ds instanceof PooledDataSource) { PooledDataSource pds = (PooledDataSource) ds; 
		System.err.println("num_connections: " + pds.getNumConnectionsDefaultUser()); 
		System.err.println("num_busy_connections: " + pds.getNumBusyConnectionsDefaultUser());
		System.err.println("num_idle_connections: " + pds.getNumIdleConnectionsDefaultUser()); 
		System.err.println(); } 
		else System.err.println("Not a c3p0 PooledDataSource!");*/
	}
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();                   
        sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
        if(sessionFactory!=null){
        	System.out.println(" sessionFactory is not null : ");
        	try {
				queryPool();
			} catch (NamingException e) {
				e.printStackTrace();
			}
        	System.out.println("databases : " +sessionFactory.openSession().createSQLQuery("show databases;").list());
        }else{
        	System.out.println(" sessionFactory is null : ");
        }
	}
}
