package com.bilgeadam.service;

import java.util.List;
import java.util.stream.Collectors;

import com.bilgeadam.entity.Book;
import com.bilgeadam.repository.BookRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class BookService extends MyFactoryService<MyFactoryRepository, Book, Long> {

	public BookService() {
		super(new BookRepository());

	}

	public List<Book> findBorrowBooks() {

		List<Book> books = findAll();

		return books.stream().filter(x -> x.isBorrowed()).collect(Collectors.toList());

	}

}
