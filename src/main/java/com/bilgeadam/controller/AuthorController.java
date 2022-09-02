package com.bilgeadam.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.bilgeadam.entity.Author;
import com.bilgeadam.service.AuthorService;

public class AuthorController {

	AuthorService authorService;
	Scanner scanner = new Scanner(System.in);

	public AuthorController() {
		this.authorService = new AuthorService();
	}

	public Optional<Author> findbyFirstNameAndLAstName(String firstname, String lastName) {

		return authorService.findbyFirstNameAndLAstName(firstname, lastName);

	}

	public List<Author> findAll() {

		return authorService.findAll();

	}

}
