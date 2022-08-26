package com.bilgeadam.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String name;
	private String surName;
	private String email;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userInformation")
	private List<PhoneNumber> phoneNumbers;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userInformation")
	private List<Address> address;

	@OneToOne(mappedBy = "userInformation")
	private User user;

	public UserInformation(String name, String surName, String email, List<PhoneNumber> phoneNumbers,
			List<Address> address, User user) {
		super();
		this.name = name;
		this.surName = surName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.address = address;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserInformation [id=" + id + ", name=" + name + ", surName=" + surName + ", email=" + email
				+ ", phoneNumbers=" + phoneNumbers + ", address=" + address + ", user=" + user + "]";
	}

}
