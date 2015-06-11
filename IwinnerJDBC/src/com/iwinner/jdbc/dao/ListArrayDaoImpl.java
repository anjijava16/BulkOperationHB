package com.iwinner.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iwinner.jdbc.utils.DbUtils;

public class ListArrayDaoImpl {

	public static List<Object[]> listOfEmployee() {
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			Connection con = DbUtils.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("select * from employee");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Object[] { rs.getString("EMPNAME"),rs.getInt("EMPID"), rs.getString("EMPDESG"),rs.getFloat("EMPSAL"),rs.getDate("EMPDATEOFJOIN")});
			}
		} catch (Exception e) {
		}
		return list;
	}

	public static void main(String[] args) {
		Iterator<Object[]> it=listOfEmployee().iterator();
		while(it.hasNext()){
			Object obj[]=(Object[])it.next();
	         System.out.println(obj[0]+"  "+obj[1]+"  "+obj[2]+"  "+obj[3]+"  "+obj[4]);		
	}
	}
}
