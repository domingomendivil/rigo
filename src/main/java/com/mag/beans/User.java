package com.mag.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	private String user;
	private String firstname;
	private String secondname;
	private Date dateOfBirth;
	
}
