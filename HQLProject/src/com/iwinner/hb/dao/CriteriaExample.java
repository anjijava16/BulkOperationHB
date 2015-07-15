package com.iwinner.hb.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.iwinner.hb.dto.Employee;
import com.iwinner.hb.utils.HibernateUtils;

public class CriteriaExample {
	
	public static void critPagination(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Employee.class);
		crit.setFirstResult(1);
		crit.setMaxResults(6);
		List<Employee> empList=crit.list();
		for(Employee emp: empList){
			System.out.println(emp.getNo()+"  "+emp.getMail());
		}
	}
	
	public static void critieraIn(){
		
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Employee.class);
		Criterion criterion = Restrictions.in("no", new Integer[]{1,3,5,6,7,8,9});
		crit.add(criterion);
		List<Employee> listEmp=crit.list();
		for(Employee emp:listEmp){
			System.out.println(emp.getNo()+"  "+emp.getMail()+"  "+emp.getFname()+"  "+emp.getLname());
		}
	}
	public static void projectionSizeDetails(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Employee.class);
		
		Projection projectioncount=Projections.rowCount();
		Projection projectioncountIdSum=Projections.sum("no");
		Projection projectioncountIdMin=Projections.min("no");
		Projection projectioncountIdMax=Projections.max("no");
		ProjectionList pList=Projections.projectionList();
		
		pList.add(projectioncount);
		pList.add(projectioncountIdSum);
		pList.add(projectioncountIdMin);
		pList.add(projectioncountIdMax);
		
		crit.setProjection(pList);
		List listOfProjection=crit.list();
		Iterator it=listOfProjection.iterator();
		while(it.hasNext()){
			/*Long count=(Long)it.next();
			System.out.println("Count Value is "+count);*/
			Object obj[]=(Object[])it.next();
			System.out.println(obj[0]+"  "+obj[1]+"  "+obj[2]+" "+obj[3]);
		}
	}

	
	public static void projectionCritiraForMultiRows(){
		
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Employee.class);
		
		// Step 1 Create Projection Object for each Property
		
		Projection projectionNo=Projections.property("no");
		Projection projectionEmail=Projections.property("mail");
		
		// Step 2 Adding Projection object to ProjectionList
		ProjectionList pList=Projections.projectionList();
		
		pList.add(projectionNo);
		pList.add(projectionEmail);
		
		
		// Step 3: Adding the ProjectionList to Criteria 
		crit.setProjection(pList);
		
		List listOfProjection=crit.list();
		Iterator it=listOfProjection.iterator();
		while(it.hasNext()){
			Object obj[]=(Object[])it.next();
			Integer number=(Integer)obj[0];
			String  email=(String)obj[1];
			System.out.println("Id ::"+number+ "Name:::  "+email);
		}
	}
	// selecting partial Object in critira
	public static void projectionCritiraForSingleRecord(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Employee.class);
		
		// Step -1 (create a Projection object for each property
		Projection projection=Projections.property("no");
		
		// Step 2 Adding projection object to ProjectionList
		
		ProjectionList pList=Projections.projectionList();
		
		pList.add(projection);
		
		// Step 3: add to Critera
		crit.setProjection(pList);
		List emp=crit.list();
		Iterator it=emp.iterator();
		while(it.hasNext()){
			/*String mail=(String)it.next();
			System.out.println(mail);
			*/
			
			Integer no=(Integer)it.next();
			System.out.println(no);
			
			
			/*Object obj[]=(Object[])it.next();
			System.out.println((String)obj[0]);*/
		}
	}
	
	public static void criteriaOrder(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Employee.class);
		//Order order=Order.desc("no");
		
		Order order=Order.desc("no"); 
		
		
		crit.addOrder(order);

		List<Employee> list=crit.list();
		for(Employee emp:list){
			System.out.println(emp.getNo()+"  "+emp.getMail());
		}
		
		
	}
	
	public static void criteraSelectBasedNames() {
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Employee.class);
		Criterion criterion = Restrictions.ilike("mail", "%s%");
		crit.add(criterion);
		List<Employee> list = crit.list();
		for (Employee emp : list) {
			System.out.println(emp.getFname() + "  " + emp.getNo());
		}
	}

	public static void criteraSelectNamesAndIdCond() {
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
	    Criteria crit=session.createCriteria(Employee.class);
	    Criterion criterionGe=Restrictions.ge("no", 10);
	    Criterion criterionName=Restrictions.ilike("mail", "%s%");
	    Criterion criterionAdd=Restrictions.and(criterionGe, criterionName);
	    crit.add(criterionAdd);
	    List<Employee> list=crit.list();
	    for(Employee emp:list){
	    	System.out.println(emp.getNo()+"   "+emp.getFname());
	    }
	}

	public static void criteraiNamesSelection(){
		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Employee.class);
		
		Criterion criterion = Restrictions.like("mail", "%s%");
		Criterion criterion1 = Restrictions.like("mail", "%s%");
		Criterion criterion2 = Restrictions.like("mail", "%s%");
		Criterion criterion3 = Restrictions.like("mail", "%s%");
		Criterion criterion4 = Restrictions.like("mail", "%s%");
		Criterion criterion5 = Restrictions.like("mail", "%s%");
		
		crit.add(criterion1);
		crit.add(criterion2);
		crit.add(criterion3);
		crit.add(criterion);
		
		List<Employee> list = crit.list();
		for (Employee emp : list) {
			System.out.println(emp.getFname() + "  " + emp.getNo());
		}
	}
	public static void criteraSelect() {

		SessionFactory sessionFactory = HibernateUtils.sessionFactoryUtil();
		Session session = sessionFactory.openSession();

		Criteria crit = session.createCriteria(Employee.class);
		List<Employee> list = crit.list();
		for (Employee emp : list) {
			System.out.println(emp.getFname() + "  " + emp.getNo());
		}
	}

	public static void main(String[] args) {
		// criteraSelect();
		//criteraSelectBasedNames();
		
		//criteraSelectNamesAndIdCond();
		//criteraiNamesSelection();
		//criteriaOrder();
		//projectionCritiraForSingleRecord();
		//projectionCritiraForMultiRows();
		//projectionSizeDetails();
		//critPagination();
		critieraIn();
	}
}
