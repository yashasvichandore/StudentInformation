package com.tut1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static  void main(String []args) {
		//get,load
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Student student=(Student)session.get(Student.class,101);
		System.out.println(student);
		Address ad=(Address)session.get(Address.class,1);
		
		//System.out.println(ad);
		System.out.println(ad.getStreet() );
		session.close();
		factory.close();
	}
}