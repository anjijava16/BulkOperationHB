package com.iwinner.jdbc.dao;

import com.iwinner.jdbc.dto.EmployeeDTO;

public interface EmployeeDaoIF {

public EmployeeDTO getEmployeeDetails(String empName); //One

//public List<EmployeeDTO> getListOfEmployeeDetails();
/*
public Integer empId(String empName);*/
public void updateEmployeeDetails(String empName,Float empSal,String empDesg);
//public Integer updateDetails(String empName,String empDesg);
public void deleteEmployee(String empName);

}
