package com.iwinner.jdbc.dao;

import com.iwinner.jdbc.dto.EmployeeDTO;

public interface EmployeeDaoIF {

public EmployeeDTO getEmployeeDetails(String empName);
public void updateEmployeeDetails(String empName,Float empSal,String empDesg);
}
