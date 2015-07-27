package com.iwinner.indus.admin.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.iwinner.indus.admin.dto.Employee;
import com.iwinner.indus.admin.utils.HibernateUtils;

public class LoginDaoImpl {
	public static String getLoginDetails() {
		
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.eq("no", 10));
		Employee emp = (Employee) crit.uniqueResult();
		String res = emp.toString();
		
		
		return res;
	}

}
