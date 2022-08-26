package com.bilgeadam.repository;

import com.bilgeadam.entity.User;
import com.bilgeadam.utility.MyFactoryRepository;

public class UserRepository extends MyFactoryRepository<User, Long> {

	public UserRepository() {
		super(new User());

	}

}
