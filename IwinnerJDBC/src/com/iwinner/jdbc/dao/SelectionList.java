package com.iwinner.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iwinner.jdbc.dto.Employee;
import com.iwinner.jdbc.utils.DbUtils;

public class SelectionList {
	
public static Object[] selectListOfElements(){
	List<Employee> list=new ArrayList<Employee>();
	Object obj[]=null;
	try{
	Connection  conn=DbUtils.getConnection();
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery("select * from EMPLOYEEHB_ONE");
	System.out.println(rs.getRow());
	while(rs.next()){
		Employee  emp=new Employee();
		emp.setNo(rs.getInt("EID"));
		emp.setFirstname(rs.getString("FIRSTNAME"));
		emp.setLastname(rs.getString("LASTNAME"));
		emp.setEmail(rs.getString("EMAIL"));
		list.add(emp);
	}
	}catch(Exception e){
	}
	return list.toArray();

}
public static void main(String[] args) {
	Object obj[]=selectListOfElements();
	
	for(Object empObj:obj){
		Employee emp=(Employee)empObj;
		System.out.println(emp.getNo());
	}/*
	for(int i=0;i<obj.length;i++){
		System.out.println(obj[i]);
	}
*/}
}
