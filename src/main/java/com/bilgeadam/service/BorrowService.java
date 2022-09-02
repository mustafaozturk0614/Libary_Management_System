package com.bilgeadam.service;

import com.bilgeadam.entity.Borrow;
import com.bilgeadam.repository.BorrowRepository;
import com.bilgeadam.utility.MyFactoryRepository;
import com.bilgeadam.utility.MyFactoryService;

public class BorrowService extends MyFactoryService<MyFactoryRepository, Borrow, Long> {

	public BorrowService() {
		super(new BorrowRepository());

	}

}
