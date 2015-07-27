package com.iwinner.jdbc.dto;

public class Employee {
	private Integer no;
	private String firstname;
	private String lastname;
	private String email;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [no=" + no + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + "]";
	}
	
	

}
