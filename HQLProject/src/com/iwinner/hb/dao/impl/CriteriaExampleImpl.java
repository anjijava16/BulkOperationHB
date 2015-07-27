package com.iwinner.hb.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.iwinner.hb.dto.Employee;
import com.iwinner.hb.utils.HibernateUtils;

public class CriteriaExampleImpl {
	public static Employee getEmployeeDetails() {
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();

		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.eq("no", 10));
		return (Employee) crit.uniqueResult();

	}

	public static void main(String[] args) {
		System.out.println(getEmployeeDetails());
	}
}
