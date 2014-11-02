/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.Iterator;
import java.util.List;
import model.Barang;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author linuxluv
 */
public class DbOperate {
    //test select dr db
    public void ngeTestRead() throws Exception {
        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session sess = sessFact.getCurrentSession();
        Transaction tr = sess.beginTransaction();
        Query query = sess.createQuery("from Barang");
        List result = query.list(); 
        Iterator it = result.iterator();
//        System.out.println("id  sname  sroll  scourse");
        while(it.hasNext()){
          Barang st = (Barang) it.next();
          System.out.print(st.getId_barang());
          System.out.print("   "+st.getNama_barang());
          System.out.print("   "+st.getStok_barang());
          System.out.println();
        }
        sessFact.close();
    }
    
    //get barang dr db
    public List<Barang> getBarang() throws Exception {
        SessionFactory sessFact = HibernateUtil.getSessionFactory();
        Session sess = sessFact.getCurrentSession();
        Transaction tr = sess.beginTransaction();
        Query query = sess.createQuery("from Barang");
        List result = query.list();
        return result;
    }
}
