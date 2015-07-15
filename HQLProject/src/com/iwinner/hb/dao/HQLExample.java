package com.iwinner.hb.dao;

import java.util.Iterator;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.dto.Employee;
import com.iwinner.hb.utils.HibernateUtils;

public class HQLExample {

	public static void sumOfElements(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();

		Session session = sessionFactory.openSession();

		Query q=session.createQuery("select count(*) from Employee");  
		List<Employee> list=q.list();  
		    Iterator<Employee> itr=list.iterator();  
		    while(itr.hasNext()){  
		        System.out.println(itr.next());  
		}  
		    /*
		    Hibernate: select count(*) as col_0_0_ from EmployeeHb_ONE employee0_
		    49*/
	}

	public static void deleteHQL(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();

		Session session = sessionFactory.openSession();

		// HQL query
		Transaction tx=session.beginTransaction();
		Query query = session.createQuery("Delete from  Employee  where no=:noI ");
		query.setParameter("noI", 2);
		int result=query.executeUpdate();
		
		tx.commit();
		System.out.println("Delete Employee  Count is "+result);
		
		
	}
	public static void updateHQL(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();

		Session session = sessionFactory.openSession();

		// HQL query
		Transaction tx=session.beginTransaction();
		Query query = session.createQuery("Update Employee  set mail=:mailId where no=:noI ");
		
		query.setParameter("mailId", "ajun@gmail.com");
		query.setParameter("noI", 10);

		int result=query.executeUpdate();
		
		tx.commit();
		System.out.println("Result Count is "+result);
		
		
	}
	
	public static void selectOps() {

		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();

		Session session = sessionFactory.openSession();

		// HQL query

		Query query = session.createQuery("from Employee");

		List<Employee> list = query.list();

		for (Employee emp : list) {
			System.out.println(emp.getFname() + "  " + emp.getLname() + "  "
					+ emp.getNo());
		}

	}

	public static void pagenationHQL(int start, int end) {
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();

		Session session = sessionFactory.openSession();

		// HQL query

		Query query = session
				.createQuery("Select e.no,e.fname,e.mail from Employee e"); // 4
		query.setFirstResult(start);   // By default google take from 1 to 10
		                               // Here first index is FirstResult :: 1 and maxResult is 10
		query.setMaxResults(end);
		// columns
		List list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj[] = (Object[]) it.next();
			System.out.println(obj[0] + "   " + obj[1] + "  " + obj[2]);
		}

	}

	public static void load() {
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();

		Session session = sessionFactory.openSession();

		// HQL query

		Query query = session
				.createQuery("Select e.fname,e.mail from Employee e"); // 4
																		// columns
		List list = query.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj[] = (Object[]) it.next();
			System.out.println(obj[0] + "   " + obj[1]);
		}
	}

	public static void insertNewRecord() {
		SessionFactory factory =HibernateUtils.sessionFactoryUtil();
		Session session = factory.openSession();
       Transaction tx=session.beginTransaction();
		Query qry = session.createQuery("insert into Product(productId,proName,price)select i.itemId,i.itemName,i.itemPrice from Items i where i.itemId=10");
		
		int res = qry.executeUpdate();

		tx.commit();
		System.out.println("Command successfully executed....");
		System.out.println("Numer of records effected...," + res);

		session.close();
		factory.close();	}

	public static void main(String[] args) {
		// selectOps();
		// load();
		//pagenationHQL(1, 2);
		// insertNewRecord();
		updateHQL();
		//deleteHQL();
		//sumOfElements();
	}
}
