package com.bilgeadam.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Debt {

	private Long id;

	@OneToOne
	@JoinColumn(name = "borrow_id", referencedColumnName = "id")
	private Borrow borrow;

	private boolean isPaid;

	private Date paidDate;

	private int delayTime;

	private double amount;

}
