package com.tut1;

import java.util.Date;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started.." );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        //creating Student
        Student st=new Student();
        st.setId(101);
        st.setName("JOHN");
        st.setCity("DELHI");
       System.out.println(st);
       //creating object of address class
       Address ad=new Address();
       ad.setStreet("street1");
       ad.setCity("Indore");
       ad.setOpen(true);
       ad.setAddedDate(new Date());
       ad.setX(1234.234);
        
       Session session=factory.openSession();
        Transaction  tx= session.beginTransaction();
       session.save(st);
       session.save(ad);
        tx.commit();
        
        session.close();
        System.out.println("Done");
        
       // System.out.println(factory);
           
    }
}
