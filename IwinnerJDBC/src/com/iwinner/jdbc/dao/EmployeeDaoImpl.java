package com.iwinner.jdbc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iwinner.jdbc.dto.EmployeeDTO;
import com.iwinner.jdbc.utils.DbUtils;
import com.iwinner.jdbc.utils.IwinnerConstants;

public class EmployeeDaoImpl implements EmployeeDaoIF {

	private static Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class);
	
	public EmployeeDTO getEmployeeDetails(String empName) {
	LOGGER.info("##### getEmployeeDetails is stared #####");
	EmployeeDTO empDTO=new EmployeeDTO();
	
	try{
	Connection conn=DbUtils.getConnection();
	PreparedStatement pstmt=conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMPNAME=?");
	pstmt.setString(1, empName);
	LOGGER.debug("input query =["+pstmt+"]");
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()){
		empDTO.setEmpId(rs.getInt("EMPID"));
		empDTO.setEmpName(rs.getString("EMPNAME"));
		empDTO.setEmpSal(rs.getFloat("EMPSAL"));
		empDTO.setDateOfJoin(rs.getDate("EMPDATEOFJOIN"));
		empDTO.setEmpDesg(rs.getString("EMPSAL"));
	}
	}catch(Exception e){
		LOGGER.error(" Error into getEmployeeDetails()#####"+e.getMessage());
	}
	LOGGER.info("##### getEmployeeDetails is ended #####");
		
	return empDTO;
	
	}
	
	public void updateEmployeeDetails(String empName, Float empSal,
			String empDesg) {
		try{
		Connection conn=DbUtils.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(IwinnerConstants.UPDATE_EMPLOYEE);
		//UPDATE EMPLOYEE SET EMPDESG =?,EMPSAL=? WHERE EMPNAME=?
		pstmt.setString(1, empDesg);
		pstmt.setFloat(2, empSal);
		pstmt.setString(3, empName);
		LOGGER.debug("input query =["+pstmt+"]");
		int updateCount=pstmt.executeUpdate();
		if(updateCount==1){
			LOGGER.debug("employee Record is updated");
		}else{
			LOGGER.debug("employee Record not  updated");
		}
		}catch(Exception e){
			e.printStackTrace();
			LOGGER.error(" Error into updateEmployeeDetails()#####"+e.getMessage());
		}
	}
	
	public void deleteEmployee(String empName){
		try{
			Connection conn=DbUtils.getConnection();
			PreparedStatement pstmt=conn.prepareStatement(IwinnerConstants.DELETE_EMPLOYEE);
			//DELETE FROM EMPLOYEE WHERE EMPNAME=?
			pstmt.setString(1, empName);
			int deleteEmployee=pstmt.executeUpdate();
			LOGGER.debug("input query =["+pstmt+"]");
			if(deleteEmployee==1){
				LOGGER.debug("employee Record is deleted");
			}else{
				LOGGER.debug("employee Record not  deleted");
			}
			}catch(Exception e){
				e.printStackTrace();
				LOGGER.error(" Error into deleteEmployee()#####"+e.getMessage());
			}
	}
	public List<EmployeeDTO> listOfEmployees() {
	 List<EmployeeDTO> listOfEmployee=new ArrayList<EmployeeDTO>();
		try {
			Connection conn=DbUtils.getConnection();
			String query="SELECT * FROM EMPLOYEE";
			PreparedStatement pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				EmployeeDTO empDTO=new EmployeeDTO();
				empDTO.setEmpId(rs.getInt("EMPID"));
				empDTO.setEmpName(rs.getString("EMPNAME"));
				empDTO.setEmpSal(rs.getFloat("EMPSAL"));
				empDTO.setDateOfJoin(rs.getDate("EMPDATEOFJOIN"));
				empDTO.setEmpDesg(rs.getString("EMPSAL"));
				listOfEmployee.add(empDTO);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listOfEmployee;
	}
}
