package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(factory);

		Certificate certificate = new Certificate();
		certificate.setCourse("JAVA");
		certificate.setDuration("2.5");

		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("First Employee");
		emp.setCity("Ahmedabad");
		emp.setCertificate(certificate);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(emp);

		tx.commit();
		session.close();
		factory.close();
	}

}
