package com.iwinner.hb.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.dto.Employee;
import com.iwinner.hb.utils.HibernateUtils;

public class ProceduresInSelectionProImpl {

	public static void selectEmailProcedureName() {
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();

		SQLQuery query = session
				.createSQLQuery("CALL SP_PRO_OUTPARMS_CALL(:EMPID)");

		query.setParameter("EMPID", 10);

		List list = query.list();
		String email = null;
		for (int i = 0; i < list.size(); i++) {
			email = (String) list.get(i);
		}
		System.out.println("Email ID ::::===>>> " + email);

	}

	public static void selectEmployeeProce() {
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("CALL SP_SELECT_EMPLOYEE(:EMP_ID)");
		query.setParameter("EMP_ID", 10);
		query.addEntity(Employee.class);
		List<Employee> listOfEmp = query.list();
		for (Employee emp : listOfEmp) {
			System.out.println(emp.toString());
		}
	}

	public static void insertUserEmployee() {
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("CALL SP_PRO_USER_INSERTION(:USERID,:USERNAME,:USERADD,:USERDESG,:USERSAL,:USERREGDATE)");
		query.setParameter("USERID", 16);
		query.setParameter("USERNAME", "BOLLEN");
		query.setParameter("USERADD", "JAPAN");
		query.setParameter("USERDESG", "TeamdEV");
		query.setParameter("USERSAL", 6000);
		query.setParameter("USERREGDATE", new Date());
		Transaction tx = session.beginTransaction();
		int x = query.executeUpdate();
		tx.commit();
		System.out.println("Coutn values is " + x);
	}

	public static void main(String[] args) {
		 //selectEmployeeProce();
		insertUserEmployee();
		//selectEmailProcedureName();

	}
}
