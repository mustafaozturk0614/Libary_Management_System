package com.bilgeadam.repository;

import com.bilgeadam.entity.Borrow;
import com.bilgeadam.utility.MyFactoryRepository;

public class BorrowRepository extends MyFactoryRepository<Borrow, Long> {

	public BorrowRepository() {
		super(new Borrow());

	}

}
