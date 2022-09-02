package com.bilgeadam.main;

import com.bilgeadam.controller.AuthorController;
import com.bilgeadam.controller.BookController;
import com.bilgeadam.controller.EmployeeController;
import com.bilgeadam.controller.StudentController;
import com.bilgeadam.controller.UserController;

public class Test2 {

	public static void main(String[] args) {

		UserController userController = new UserController();
		StudentController studentController = new StudentController();
		EmployeeController employeeController = new EmployeeController();
		BookController bookController = new BookController();
		AuthorController authorController = new AuthorController();
//		studentController.createStudent();
//		employeeController.createEmployee();
//		authorController.findAll().forEach(s -> System.out.println(s.getBooks()));
		bookController.findBorrowBooks2().forEach(System.out::println);
	}
}
