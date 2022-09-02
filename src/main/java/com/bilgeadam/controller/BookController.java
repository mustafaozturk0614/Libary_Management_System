package com.bilgeadam.controller;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.service.AuthorService;
import com.bilgeadam.service.BookService;

public class BookController {

	BookService bookService = new BookService();
	AuthorService authorService = new AuthorService();
	Scanner scanner = new Scanner(System.in);

	public Book createBook() {

		System.out.println("Lütfen kitap adý giriniz");
		String bookname = scanner.nextLine();

		Author author = authorService.createAuthor();

		Book book = new Book(bookname, author);

		return bookService.save(book);

	}

	public List<Book> findAll() {

		return bookService.findAll();

	}

	public List<Book> findBorrowBooks() {

		List<Book> books = findAll();

		return books.stream().filter(x -> x.isBorrowed()).collect(Collectors.toList());

	}

	public List<Book> findBorrowBooks2() {

		return bookService.finByCollumnAndValue("isBorrowed", true);

	}

	public List<Book> findNotBorrowBooks() {

		return bookService.finByCollumnAndValue("isBorrowed", false);

	}

}
