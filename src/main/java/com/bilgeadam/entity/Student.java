package com.bilgeadam.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Student extends User {

	@OneToMany(mappedBy = "student")
	List<Borrow> borrows = new ArrayList<>();

	public Student() {
		super();
		setUserType(UserType.STUDENT);

		// TODO Auto-generated constructor stub
	}

	public Student(String username, String password, UserInformation userInformation) {
		super(username, password, userInformation);
		setUserType(UserType.STUDENT);
	}

	public Student(String username, String password) {
		super(username, password);
		setUserType(UserType.STUDENT);
	}

//
	public List<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}

	@Override
	public String toString() {
		return "Student [getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ "]";
	}

}
