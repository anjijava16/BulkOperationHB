package com.iwinner.jdbc.test;

import java.util.List;

import com.iwinner.jdbc.dao.EmployeeDaoImpl;
import com.iwinner.jdbc.dto.EmployeeDTO;

public class EmployeeDaoSuperTest {
	public static void main(String[] args) {
		EmployeeDaoImpl emp=new EmployeeDaoImpl();

		List<EmployeeDTO> listOfEmployee=emp.listOfEmployees();
		for(EmployeeDTO eDTO:listOfEmployee){
			System.out.println(eDTO.getEmpId()+" "+eDTO.getEmpDesg()+"  "+eDTO.getEmpName()+" "+eDTO.getEmpSal()+"  "+eDTO.getDateOfJoin());
		}
		
		// ############### Select Query ###############
		/*EmployeeDTO empD=emp.getEmployeeDetails("hbr");
		System.out.println(empD.getEmpId()+"  "+empD.getEmpDesg()+"  "+empD.getDateOfJoin());
     */
		
		

		// ###############Update Query ############### 
	/*	emp.updateEmployeeDetails("hbr",5000f,"TechLead");
	*/	
		
		// ############ Delete Query ###########
    	//emp.deleteEmployee("hbr");
	}
}
