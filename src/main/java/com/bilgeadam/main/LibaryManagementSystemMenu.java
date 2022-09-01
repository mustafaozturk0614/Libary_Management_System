package com.bilgeadam.main;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.bilgeadam.controller.UserController;
import com.bilgeadam.entity.User;
import com.bilgeadam.service.UserService;

public class LibaryManagementSystemMenu {
	Scanner scanner = new Scanner(System.in);

	UserService userService = new UserService();
	UserController userController = new UserController();

	public void mainMenu() {
		int input = 2;
		do {
			System.out.println("1-Giri�");
			System.out.println("2-��k��");
			System.out.println("L�tfen i�lem se�iniz");

			input = Integer.parseInt(scanner.nextLine());

			switch (input) {
			case 1:
				login2();
				break;

			default:
				break;
			}

		} while (input != 2);

	}

	private void login() {
		String username = scanner.nextLine();
		String password = scanner.nextLine();

		User user;
		List<User> users = userService.finByCollumnAndValue("username", username);
		if (users.size() > 0) {
			user = users.get(0);
			if (user.getPassword().equals(password)) {

				System.out.println("Kulla�n�c� bulundu");
				System.out.println(user);

			} else {
				System.out.println("Kullan�c� bulunamad�");
			}
		}

		else {

			System.out.println("Kullan�c� bulunamad�");
		}
	}

	private void login2() {
		String username = scanner.nextLine();
		String password = scanner.nextLine();
		Optional<User> user = userController.findbyUsernameAndPassword(username, password);
		if (user.isPresent()) {
			System.out.println(user);
		}

	}

	public static void main(String[] args) {
		LibaryManagementSystemMenu libaryManagementSystemMenu = new LibaryManagementSystemMenu();
		libaryManagementSystemMenu.mainMenu();
	}

}
