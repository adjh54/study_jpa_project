package com.study.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "tb_book")
public class BookEntity {

	@Id
	@GeneratedValue
	private int id;
	
//	@OneToMany
	private String bookId;
	
	private String bookName;
	
}
