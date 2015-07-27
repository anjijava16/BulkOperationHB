package com.iwinner.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
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

	public static JsonObject listOfEmploee(){
		JsonObject jsonObj=new JsonObject();
		try{
		Connection con = DbUtils.getConnection();
		PreparedStatement pstmt = con
				.prepareStatement("select * from employee_tbl WHERE EMPNAME='m'");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ResultSetMetaData columnInfo = rs.getMetaData();
			for(int i=1;i<=columnInfo.getColumnCount();i++){
				jsonObj.addProperty(columnInfo.getColumnName(i), rs.getString(i));
			}
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonObj;
	}

	public static List<JsonObject> listOfEmploees(){
		List<JsonObject> jsonObjList=new ArrayList<JsonObject>();
		
		try{
		Connection con = DbUtils.getConnection();
		PreparedStatement pstmt = con
				.prepareStatement("select * from employee");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			JsonObject jsonObj=new JsonObject();
			ResultSetMetaData columnInfo = rs.getMetaData();
			for(int i=1;i<=columnInfo.getColumnCount();i++){
				jsonObj.addProperty(columnInfo.getColumnName(i), rs.getString(i));
				
			}
			jsonObjList.add(jsonObj);	
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonObjList;
	}
	
	public static void main(String[] args) {
		List<JsonObject> jsonObj=listOfEmploees();
		for(JsonObject jObj:jsonObj){
			System.out.println(jObj.get("EMPID").getAsInt());
			System.out.println(jObj.get("EMPNAME").getAsString());
			System.out.println(jObj.get("EMPDESG").getAsString());
			System.out.println(jObj.get("EMPSAL").getAsFloat());
			System.out.println(jObj.get("EMPDATEOFJOIN").getAsString());
			System.out.println("+++++");
		}
	
	}
	/*
	public static void main(String[] args) {
		Iterator<Object[]> it=listOfEmployee().iterator();
		while(it.hasNext()){
			Object obj[]=(Object[])it.next();
	         System.out.println(obj[0]+"  "+obj[1]+"  "+obj[2]+"  "+obj[3]+"  "+obj[4]);		
	}
	}*/
	
}
