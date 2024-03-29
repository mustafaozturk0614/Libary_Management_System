package com.bilgeadam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String phoneNumber;

//	@ManyToOne
//	private UserInformation userInformation;

	public PhoneNumber(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;

	}

	public PhoneNumber() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "PhoneNumber [id=" + id + ", phoneNumber=" + phoneNumber + "]";
	}

}
