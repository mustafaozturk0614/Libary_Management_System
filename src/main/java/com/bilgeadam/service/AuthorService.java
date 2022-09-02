package com.bilgeadam.service;

import java.util.Optional;
import java.util.Scanner;

import com.bilgeadam.entity.Author;
import com.bilgeadam.repository.AuthorRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class AuthorService extends MyFactoryService<MyFactoryRepository, Author, Long> {

	private static final AuthorRepository AUTHOR_REPOSITORY = new AuthorRepository();
	Scanner scanner = new Scanner(System.in);

	public AuthorService() {
		super(AUTHOR_REPOSITORY);

	}

	public Optional<Author> findbyFirstNameAndLAstName(String firstname, String lastName) {

		Optional<Author> authOptional = AUTHOR_REPOSITORY.findbyFirstNameAndLAstName(firstname, lastName);
		if (authOptional.isPresent()) {

			System.out.println("Yazar db mevcut");

		} else {

			System.out.println("Yazar db mevcut deðil");

		}

		return authOptional;
	}

	public Author createAuthor() {
		System.out.println("Lütfen yazar adý adý giriniz");
		String authorFirstName = scanner.nextLine();
		System.out.println("Lütfen yazar soyadý adý giriniz");
		String authorLastName = scanner.nextLine();
		Optional<Author> author = findbyFirstNameAndLAstName(authorFirstName, authorLastName);
		if (author.isPresent()) {
			return author.get();
		} else {
			return save(new Author(authorFirstName, authorLastName));
		}

	}
}
