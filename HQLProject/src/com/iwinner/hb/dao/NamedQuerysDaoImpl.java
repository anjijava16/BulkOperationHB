package com.iwinner.hb.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iwinner.hb.dto.Employee;
import com.iwinner.hb.utils.HibernateUtils;

public class NamedQuerysDaoImpl {
	
	
	public static void namedHQLQuerySelection(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		Query query=session.getNamedQuery("selectIdQuery");
		query.setParameter("no", 45);
		List<Employee> listOfEmployees=query.list();
		for(Employee emp:listOfEmployees){
			System.out.println(emp.getNo()+"  "+emp.getFname()+"  "+emp.getMail());
		}
	}	
public static void namedHQLQuery(){
	SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
	Session session = sessionFactory.openSession();
	Query query=session.getNamedQuery("hqlQuery");
	List<Employee> listOfEmployees=query.list();
	for(Employee emp:listOfEmployees){
		System.out.println(emp.getNo()+"  "+emp.getFname()+"  "+emp.getMail());
	}
}







public static void namedSQLQuery(){
	SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
	Session session = sessionFactory.openSession();
	Query query=session.getNamedQuery("sqlQyery");
	// SQLQuery
	//query.addeEntity
	
	List listOfEmployees=query.list();
	Iterator it=listOfEmployees.iterator();
	while(it.hasNext()){
		Object[] obj=(Object[])it.next();
		System.out.println(obj[0]+"  "+obj[1]+"  "+obj[2]);
	}

}

public static void main(String[] args) {
	//namedHQLQuery();
	//namedSQLQuery();
	namedHQLQuerySelection();
}
}
