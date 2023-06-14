package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
//
//		/*
//		 * Question 1
//		 */
//		Question q1 = new Question();
//		q1.setQueId(101);
//		q1.setQuetion("What is JAVA?");
//
//		Answer a1 = new Answer();
//		a1.setAnsId(1);
//		a1.setAnswer("JAVA is a programing language.");
//
//		q1.setAnswer(a1);
//
//		/*
//		 * Question 2
//		 */
//		Question q2 = new Question();
//		q2.setQueId(321);
//		q2.setQuetion("What is Eclipse?");
//
//		Answer a2 = new Answer();
//		a2.setAnsId(2);
//		a2.setAnswer("Eclipse is a IDE");
//
//		q2.setAnswer(a2);
//

		/*
		 * Question q1 = new Question(); q1.setQueId(101);
		 * q1.setQuetion("What is JAVA?");
		 * 
		 * Answer a1 = new Answer(); a1.setAnsId(1);
		 * a1.setAnswer("JAVA is a programing language."); a1.setQuestion(q1);
		 * 
		 * Answer a2 = new Answer(); a2.setAnsId(2);
		 * a2.setAnswer("Java is an object-oriented programming language.");
		 * a2.setQuestion(q1);
		 * 
		 * List<Answer> ansList = new ArrayList<Answer>(); ansList.add(a1);
		 * ansList.add(a2);
		 * 
		 * q1.setAnswer(ansList);
		 */
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

//		session.save(q1);
//		session.save(a1);
//		session.save(a2);

		Question question = session.get(Question.class, 101);
		System.out.println("Question is : \n" + question.getQuetion());

		System.out.println("Answer is : ");
		for (Answer ans : question.getAnswer()) {
			System.out.println(ans.getAnswer());
		}

		tx.commit();
		session.close();
		factory.close();
	}

}
