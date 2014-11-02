/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author linuxluv
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
  
  static{
    try{
      sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }catch(Throwable th){
      System.err.println("Initial SessionFactory creation failed"+th);
      throw new ExceptionInInitializerError(th);
    }
  }
  
  public static SessionFactory getSessionFactory(){
    return sessionFactory;
  }
}
