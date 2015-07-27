package com.iwinner.indus.admin.dto;

public class Employee implements java.io.Serializable
{
	// Fileds
		private Integer no;
		private String fname;
		private String lname;
		private String mail;

		public Integer getNo() {
			return no;
		}

		public void setNo(Integer no) {
			this.no = no;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String toString() {
			return "Employee [no=" + no + ", fname=" + fname + ", lname="
					+ lname + ", mail=" + mail + "]";
		}


}
