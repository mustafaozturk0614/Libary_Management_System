package com.bilgeadam.service;

import com.bilgeadam.entity.User;
import com.bilgeadam.repository.UserRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class UserService extends MyFactoryService<MyFactoryRepository, User, Long> {

	public UserService() {
		super(new UserRepository());

	}

}
