package com.mag.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class User {

	@Id
	private String userName;

	private String firstname;
	private String secondname;
	private Date dateOfBirth;
	private String password;
	
	@ManyToMany
	@JoinTable(name="users_roles",
	joinColumns = {@JoinColumn(name = "username", referencedColumnName = "username")}, 
	inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	

	private Set<Rol> roles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Rol> getRoles() {
		return roles;
	}

}
