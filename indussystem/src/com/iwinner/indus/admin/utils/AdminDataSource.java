package com.iwinner.indus.admin.utils;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminDataSource {

	private static  DataSource ds;

	
	public static String getDataSource(){
		String res="";
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/devDB");
			Connection con = ds.getConnection();
			System.out.println(con.getClass());
			Object obj=con.getClass();
			res=obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return res;
	}
	public static void main(String[] args) {
		System.out.println(getDataSource());
	}
}
