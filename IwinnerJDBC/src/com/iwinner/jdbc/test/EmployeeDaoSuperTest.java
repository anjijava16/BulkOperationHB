package com.iwinner.jdbc.test;

import com.iwinner.jdbc.dao.EmployeeDaoImpl;
import com.iwinner.jdbc.dto.EmployeeDTO;

public class EmployeeDaoSuperTest {
	public static void main(String[] args) {
		EmployeeDaoImpl emp=new EmployeeDaoImpl();

		// ############### Select Query ###############
		EmployeeDTO empD=emp.getEmployeeDetails("anji");
		System.out.println(empD.getEmpId()+"  "+empD.getEmpDesg()+"  "+empD.getDateOfJoin());


		// ###############Update Query ############### 
		emp.updateEmployeeDetails("hbr",5000f,"TechLead");
		
		
		// ############ Delete Query ###########
    	//emp.deleteEmployee("hbr");
	}
}
