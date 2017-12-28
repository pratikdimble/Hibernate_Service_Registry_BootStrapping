package com.pratik.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name="EMPLOYEE")
public class EmpDetails {

	private int  no;
  private String  fname;
	private String  lname;
	private String  mail;

	@Id
	@Column(name="EID",length=10)
	@Type(type="int")
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Column(name="FIRSTNAME",length=20)
	@Type(type="string")
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name="LASTNAME",length=20)
	@Type(type="string")
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Column(name="EMAIL",length=20,unique=true,nullable=false)
	@Type(type="string")
	@Transient
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
