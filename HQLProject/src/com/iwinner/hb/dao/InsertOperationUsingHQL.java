package com.iwinner.hb.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.iwinner.hb.dto.Items;
import com.iwinner.hb.utils.HibernateUtils;

public class InsertOperationUsingHQL {

	public static void main(String[] args) {

		
		SessionFactory factory =HibernateUtils.sessionFactoryUtil();
		Session session = factory.openSession();

		Query qry = session
				.createQuery("insert into Product(productId,proName,price)select i.itemId,i.itemName,i.itemPrice from Items i where i.itemId= ?");
		qry.setParameter(0, 600);
		int res = qry.executeUpdate();

		System.out.println("Command successfully executed....");
		System.out.println("Numer of records effected...," + res);

		session.close();
		factory.close();
	}
	public static void main1(String[] args) {
		SessionFactory factory =HibernateUtils.sessionFactoryUtil();
		Session session = factory.openSession();

		Items it=new Items();
		it.setItemId(10);
		it.setItemName("a");
		it.setItemPrice(10d);
		
		Transaction tx=session.beginTransaction();
		session.save(it);
		tx.commit();
		
	}

}