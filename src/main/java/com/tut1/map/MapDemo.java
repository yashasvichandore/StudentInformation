package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        //creating question
        Question q1=new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is java");
        
        //creating answer
        Answer answer=new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("Java is programming language");
        q1.setAnswer(answer);

        //creating question
        Question q2=new Question();
        q2.setQuestionId(242);
        q2.setQuestion("What is collection Framework");
        
        //creating answer
        Answer answer1=new Answer();
        answer1.setAnswerId(344);
        answer1.setAnswer("API to work object in java");
        q2.setAnswer(answer1);

        //session
        Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
        s.save(q1);
        s.save(q2);
        s.save(answer1);
        s.save(answer);
        tx.commit();
        s.close();
        
        factory.close();
	}

}
