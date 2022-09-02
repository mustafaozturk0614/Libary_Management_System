package com.bilgeadam.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.transaction.Transactional;

import com.bilgeadam.entity.Student;
import com.bilgeadam.entity.UserInformation;
import com.bilgeadam.service.StudentService;

public class StudentController {

	StudentService studentService;
	Scanner scanner = new Scanner(System.in);
	UserInformationController userInformationController;

	public StudentController() {
		// TODO Auto-generated constructor stub
		this.userInformationController = new UserInformationController();
		this.studentService = new StudentService();

	}

	public Student createStudent() {
		System.out.println("L�tfen kullan�c� isminizi giriniz");
		String userName = scanner.nextLine();
		System.out.println("L�tfen �ifrenizi giriniz");
		String password = scanner.nextLine();
		Student user = new Student(userName, password);
		UserInformation userInformation = userInformationController.createUserInformation();
		user.setUserInformation(userInformation);
		userInformation.setUser(user);
		return studentService.save(user);

	}

	public List<Student> findAll() {

		return studentService.findAll();

	}

	public Student findById(Long id) {

		return studentService.findById(id).get();

	}

	public void updateStudent() {
		System.out.println("G�ncellemek istedi�iniz Ogrenci �d sini giriniz");
		Optional<Student> student = studentService.findById(Long.parseLong(scanner.nextLine()));

		if (student.isPresent()) {
			System.out.println("G�ncellemek istedi�iniz kullan�c� ismini giriniz");
			student.get().setUsername(scanner.nextLine());
			System.out.println("G�ncellemek istedi�iniz �ifreyi giriniz");
			student.get().setPassword(scanner.nextLine());

			studentService.update(student.get());
		} else {
			System.out.println("kullan�c� bulunamad�");
		}

	}

	@Transactional
	public void deleteById(Long id) {

		studentService.deleteById(id);
	}

}
