package com.bilgeadam.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.Borrow;
import com.bilgeadam.entity.DelayStatus;
import com.bilgeadam.entity.Student;
import com.bilgeadam.service.BookService;
import com.bilgeadam.service.BorrowService;
import com.bilgeadam.service.StudentService;

public class BorrowController {

	BorrowService borrowService = new BorrowService();
	BookService bookService = new BookService();
	StudentService service = new StudentService();
	Scanner scanner = new Scanner(System.in);

	public void borrowBook(Student user, Long id) {

		System.out.println("Kitap kaç günlüðüne kiralancak");

		int day = Integer.parseInt(scanner.nextLine());

		LocalDate date = LocalDate.now();
		Book book = bookService.findById(id).get();
		Borrow borrow = new Borrow(date, book, date.plusDays(day));
		borrow.setStudent(user);
		user.getBorrows().add(borrow);
		book.setBorrowed(true);
		book.getBorrows().add(borrow);
		borrow.setDelayStatus(DelayStatus.NODELAY);
		try {
			borrowService.save(borrow);

		} catch (Exception e) {

		}
		try {
			bookService.update(book);
		} catch (Exception e) {

		}

	}

}
