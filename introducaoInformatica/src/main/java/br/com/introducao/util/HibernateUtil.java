
package br.com.introducao.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.mule.api.lifecycle.InitialisationException;



public class HibernateUtil {
    private static SessionFactory sessionFactory ;
    public static final String HIBERNATE_SESSION = "hibenate_session"; 
    
    static{
        try {
            System.out.println("Tentano configurar a SF");
            Configuration configuration = new Configuration().configure();
            
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).buildServiceRegistry();
            
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("Session Factory criada normalmente");
            
        } catch (Exception ex) {
            System.out.println("Erro no SF " +ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * @return the sessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
   
}
