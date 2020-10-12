package com.study.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="tb_user")
public class User {

	public User() {
		
	}
	
	public User (String username, int age) {
		this.username = username;
		this.age = age;
	}
	
	public User(String username, int age, String email) {
		this.username = username;
		this.age = age;
		this.email = email;
	}

	@Id
	@GeneratedValue
	private Long id;

	private String email;
	
	private String password;

	private String username;

	private int age;

	private String address;
	
}
