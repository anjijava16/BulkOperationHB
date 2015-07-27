package com.iwinner.hb.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.dto.Employee;
import com.iwinner.hb.utils.HibernateUtils;

public class NativeSQL {

	public static void selectNativeSQL(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		
		SQLQuery query=session.createSQLQuery("select * from EmployeeHb_ONE");
		
		List lis=query.list();
		
		Iterator it=lis.iterator();
		while(it.hasNext()){
			Object obj[]=(Object[])it.next();
			System.out.println(obj[0]+"  "+obj[1]+"  "+obj[2]+"  "+obj[3]);
		}
	}
	
	public static void selectAddEntitySQL(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select * from EmployeeHb_ONE");
		query.addEntity(Employee.class);
		List<Employee> listOfEmployees=query.list();
		for(Employee emp:listOfEmployees){
			System.out.println(emp.getFname()+"  "+emp.getNo()+"  "+emp.getMail());
		}
		
	}

	public static void selectQueryAddEntity(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select * from EmployeeHb_ONE");
		query.addEntity(Employee.class);
        List<Employee> empList=query.list();
        for(Employee emp:empList){
        	System.out.println(emp.getNo()+"  "+emp.getFname());
        }
	}
	public static void nonSelecQuery(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();

		// Postinal Parmaeter
		/* **************************************
		SQLQuery query=session.createSQLQuery("update   EmployeeHb_ONE set EMAIL=? where EID=?");
		query.setParameter(0, "azx@gmail.com");
		query.setParameter(1, 48);
		*/
		// Nameed Parameters
		SQLQuery query=session.createSQLQuery("update   EmployeeHb_ONE set EMAIL=:emailId where EID=:eId");
		query.setParameter("emailId", "named@gmail.com");
		query.setParameter("eId",47);
		Transaction tx=session.beginTransaction();
		int x=query.executeUpdate();
		
		tx.commit();
		System.out.println(x);
		
	}
	public static void selectQuery(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select * from EmployeeHb_ONE");
		List list=query.list();
		Iterator it=list.iterator();
		while(it.hasNext()){
			Object obj[]=(Object[])it.next();
			System.out.println(obj[0]+"   "+obj[1]);
		}
	   
	}
	public static void main(String[] args) {
		//selectQuery();
		//selectQueryAddEntity();
		nonSelecQuery();
		 //selectNativeSQL();
		//selectAddEntitySQL();
	}
}
