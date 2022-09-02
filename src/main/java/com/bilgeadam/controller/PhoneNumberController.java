package com.bilgeadam.controller;

import java.util.Scanner;

import com.bilgeadam.entity.PhoneNumber;
import com.bilgeadam.service.PhoneNumberService;

public class PhoneNumberController {

	PhoneNumberService phoneNumberService;
	Scanner scanner = new Scanner(System.in);

	public PhoneNumberController() {
		// TODO Auto-generated constructor stub
		this.phoneNumberService = new PhoneNumberService();
	}

	public PhoneNumber createPhoneNumber() {

		System.out.println("L�tfen telefon numaran�z� giriniz");
		String phoneNumber = scanner.nextLine();
		return phoneNumberService.save(new PhoneNumber(phoneNumber));
	}

	public PhoneNumber findById(Long id) {

		return phoneNumberService.findById(id).get();

	}

	public void deletedById(Long id) {

		phoneNumberService.deleteById(id);

	}
}
