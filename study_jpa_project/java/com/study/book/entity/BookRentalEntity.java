package com.study.book.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "tb_book_rental")
public class BookRentalEntity {

	@Id
	@GeneratedValue
	private int id;

//	@ManyToOne(targetEntity = BookEntity.class)
//	@JoinColumn(name = "book_id")
//	private BookEntity bookEntity;

	private String userId;

	private String userName;

	private boolean returned = false;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createAt;

}
