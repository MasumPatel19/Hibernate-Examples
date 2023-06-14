package com.manymapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainMapping {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Emp emp1 = new Emp();
		emp1.setEid(1);
		emp1.setEname("Employee 1");

		Emp emp2 = new Emp();
		emp2.setEid(2);
		emp2.setEname("Employee 2");

		Project p1 = new Project();
		p1.setPid(1);
		p1.setPname("Project 1");

		Project p2 = new Project();
		p2.setPid(2);
		p2.setPname("Project 2");

		List<Emp> list1 = new ArrayList<Emp>();
		list1.add(emp1);
		list1.add(emp2);

		List<Project> list2 = new ArrayList<Project>();
		list2.add(p1);
		list2.add(p2);

		emp1.setProjects(list2);
//		emp2.setProjects(list2);

//		p1.setEmps(list1);
		p2.setEmps(list1);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(emp1);
		session.save(emp2);
		session.save(p1);
		session.save(p2);

		tx.commit();
		session.close();
		factory.close();
	}

}
