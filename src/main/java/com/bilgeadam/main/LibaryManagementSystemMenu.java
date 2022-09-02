package com.bilgeadam.main;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.bilgeadam.controller.BookController;
import com.bilgeadam.controller.BorrowController;
import com.bilgeadam.controller.UserController;
import com.bilgeadam.entity.Student;
import com.bilgeadam.entity.User;
import com.bilgeadam.entity.UserType;
import com.bilgeadam.service.StudentService;
import com.bilgeadam.service.UserService;

/*
 * 
 * usertyepe a gore iki tane ayr� menu hazr�layla�m 
 * 
 * student menu
 * employee menu
 * 
 * 
 * 
 * 
 */
public class LibaryManagementSystemMenu {
	Scanner scanner = new Scanner(System.in);

	UserService userService = new UserService();
	StudentService studentService = new StudentService();
	UserController userController = new UserController();
	BookController bookController = new BookController();
	BorrowController borrowController = new BorrowController();

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
			if (user.get().getUserType().equals(UserType.STUDENT)) {

				studentMenu(studentService.findById(user.get().getId()).get());

			} else if (user.get().getUserType().equals(UserType.EMPLOYEE)) {
				employeeMenu(user.get());
			}

		}

	}

	public void studentMenu(Student user) {

		int input = 0;
		do {
			System.out.println("1-Kitap �d�n� al");
			System.out.println("2-Kitap Teslim et");
			System.out.println("2-DAha �nce �d�n� ald���m kitaplar");
			System.out.println("0-��k��");
			System.out.println("L�tfen i�lem se�iniz");

			input = Integer.parseInt(scanner.nextLine());

			switch (input) {
			case 1:
				bookController.findNotBorrowBooks().forEach(s -> System.out.println(s.getId() + "-" + s.getTitle()));
				System.out.println("L�tfen �d�n� alaca��n�z kitap id sini giriniz");
				Long bookId = Long.parseLong(scanner.nextLine());
				borrowController.borrowBook(user, bookId);
				break;

			default:
				break;
			}

		} while (input != 0);

	}

	public void employeeMenu(User user) {
		int input = 0;
		do {
			System.out.println("1-Kitap Ekle");
			System.out.println("2-Kitaplar� Listele");
			System.out.println("3-Kitap Sil");
			System.out.println("4-Kitap G�ncelle");
			System.out.println("5-Yazar Ekle");
			System.out.println("6-Yazar Sil");
			System.out.println("7-Yazar G�ncelle");
			System.out.println("8-Yazarlar� Getir");
			System.out.println("8-��k��");

			input = Integer.parseInt(scanner.nextLine());

			switch (input) {
			case 1:
				bookController.createBook();
				break;

			default:
				break;
			}

		} while (input != 0);

	}

	public static void main(String[] args) {
		LibaryManagementSystemMenu libaryManagementSystemMenu = new LibaryManagementSystemMenu();
		libaryManagementSystemMenu.mainMenu();
	}

}
