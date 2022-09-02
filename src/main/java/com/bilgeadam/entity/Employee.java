package com.bilgeadam.entity;

import javax.persistence.Entity;

@Entity
public class Employee extends User {

	public Employee() {
		super();
		setUserType(UserType.EMPLOYEE);
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, String password) {
		super(username, password);
		setUserType(UserType.EMPLOYEE);
	}

	public Employee(String username, String password, UserInformation userInformation) {
		super(username, password, userInformation);
		setUserType(UserType.EMPLOYEE);
	}

	@Override
	public String toString() {
		return "Employee [getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ "]";
	}

}
