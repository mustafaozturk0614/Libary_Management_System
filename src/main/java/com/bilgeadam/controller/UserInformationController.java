package com.bilgeadam.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bilgeadam.entity.Address;
import com.bilgeadam.entity.PhoneNumber;
import com.bilgeadam.entity.User;
import com.bilgeadam.entity.UserInformation;
import com.bilgeadam.service.UserInformationService;
import com.bilgeadam.service.UserService;

public class UserInformationController {

	UserInformationService userInformationService;
	Scanner scanner = new Scanner(System.in);
	PhoneNumberController phoneNumberController;
	AddressController addressController;
	UserService userService;

	public UserInformationController() {
		// TODO Auto-generated constructor stub
		this.userInformationService = new UserInformationService();
		this.addressController = new AddressController();
		this.phoneNumberController = new PhoneNumberController();
		this.userService = new UserService();
	}

	public UserInformation createUserInformation(User user) {
		System.out.println("L�tfen  isminizi giriniz");
		String name = scanner.nextLine();
		System.out.println("L�tfen soyad�n�z� giriniz");
		String lastName = scanner.nextLine();
		System.out.println("L�tfen e-mailnizi giriniz");
		String email = scanner.nextLine();
		List<PhoneNumber> phoneNumbers = new ArrayList<>();
		List<Address> addresses = new ArrayList<>();
		phoneNumbers.add(phoneNumberController.createPhoneNumber());
		addresses.add(addressController.createAddress());
		UserInformation userInformation = new UserInformation(name, lastName, email, phoneNumbers, addresses);
		userInformation.setUser(userService.findById(user.getId()).get());
		return userInformationService.save(userInformation);

	}

	public UserInformation createUserInformation() {
		System.out.println("L�tfen  isminizi giriniz");
		String name = scanner.nextLine();
		System.out.println("L�tfen soyad�n�z� giriniz");
		String lastName = scanner.nextLine();
		System.out.println("L�tfen e-mailnizi giriniz");
		String email = scanner.nextLine();
		List<PhoneNumber> phoneNumbers = new ArrayList<>();
		List<Address> addresses = new ArrayList<>();
		phoneNumbers.add(phoneNumberController.createPhoneNumber());
		addresses.add(addressController.createAddress());
		UserInformation userInformation = new UserInformation(name, lastName, email, phoneNumbers, addresses);
		return userInformation;

	}

	public UserInformation findById(Long id) {

		return userInformationService.findById(id).get();

	}

	public void deleteById(Long id) {

		userInformationService.deleteById(id);
	}

}
