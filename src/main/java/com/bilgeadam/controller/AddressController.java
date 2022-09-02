package com.bilgeadam.controller;

import java.util.Scanner;

import com.bilgeadam.entity.Address;
import com.bilgeadam.service.AddressService;

public class AddressController {

	AddressService addressService;
	Scanner scanner = new Scanner(System.in);

	public AddressController() {
		this.addressService = new AddressService();
	}

	public Address createAddress() {

		System.out.println("Lütfen adresinizi giriniz");
		String address = scanner.nextLine();
		return addressService.save(new Address(address));
	}

	public Address findById(Long id) {

		return addressService.findById(id).get();

	}

	public void deletedById(Long id) {

		addressService.deleteById(id);

	}

}
