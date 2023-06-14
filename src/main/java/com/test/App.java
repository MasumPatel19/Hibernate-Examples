package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("In Main...");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(factory);

//		Employee employee = new Employee();
////		employee.setId(103);
//		employee.setName("Emp2");
//		employee.setCity("EmpCity2");
//
//		Address address = new Address();
////		address.setAddressId();
//		address.setStreet("street1");
//		address.setCity("surat");
//		address.setAddDate(new Date());
//		address.setIsOpen(false);
//		address.setX(22.90);

		FileInputStream fis = new FileInputStream("src/main/java/bgimg.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
//		address.setImage(data);

//		System.out.println(employee);
//		System.out.println(address);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		/*
		 * Save data
		 */

//		session.save(employee);
//		session.save(address);

		/*
		 * get data
		 */

		// load() give exceptoin if id is not present
		Employee getEmp = session.load(Employee.class, 4);
		System.out.println(getEmp);

		// get() return null if id is not present
//		Address getAddress = session.get(Address.class, 5);
//		System.out.println(getAddress);

//		session.getTransaction().commit();
		tx.commit();
		session.close();

	}
}
