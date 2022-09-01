package com.bilgeadam.controller;

import java.util.Optional;
import java.util.Scanner;

import com.bilgeadam.entity.User;
import com.bilgeadam.service.UserService;

public class UserController {

	UserService userService;
	Scanner scanner = new Scanner(System.in);

	public UserController() {
		this.userService = new UserService();
	}

	public User ceateUser() {
		System.out.println("Lütfen kullanýcý isminizi giriniz");
		String userName = scanner.nextLine();
		System.out.println("Lütfen þifrenizi giriniz");
		String password = scanner.nextLine();

		return userService.save(new User(userName, password));

	}

	public Optional<User> findbyUsernameAndPassword(String username, String password) {

		return userService.findbyUsernameAndPassword(username, password);

	}

}
