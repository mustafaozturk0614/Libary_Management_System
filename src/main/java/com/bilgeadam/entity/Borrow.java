package com.bilgeadam.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	LocalDate borrowDate;

	@ManyToOne
	Student student;

	@ManyToOne(cascade = CascadeType.MERGE)
	Book book;

	LocalDate retunDate;

	@Enumerated(EnumType.STRING)
	DelayStatus delayStatus;

	public Borrow(LocalDate borrowDate, Student student, Book book, LocalDate retunDate) {
		super();
		this.borrowDate = borrowDate;
//		this.student = student;
		this.book = book;
		this.retunDate = retunDate;
	}

	public Borrow(LocalDate borrowDate, Student student, Book book, LocalDate retunDate, DelayStatus delayStatus) {
		super();
		this.borrowDate = borrowDate;
//		this.student = student;
		this.book = book;
		this.retunDate = retunDate;
		this.delayStatus = delayStatus;
	}

	public Borrow() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getRetunDate() {
		return retunDate;
	}

	public void setRetunDate(LocalDate retunDate) {
		this.retunDate = retunDate;
	}

	public DelayStatus getDelayStatus() {
		return delayStatus;
	}

	public void setDelayStatus(DelayStatus delayStatus) {
		this.delayStatus = delayStatus;
	}

	@Override
	public String toString() {
		return "Borrow [id=" + id + ", borrowDate=" + borrowDate + ", student=" + ", book=" + book + ", retunDate="
				+ retunDate + "delayStatus" + delayStatus + "]";
	}

}
