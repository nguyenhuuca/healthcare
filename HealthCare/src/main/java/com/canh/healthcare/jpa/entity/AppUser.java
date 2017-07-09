package com.canh.healthcare.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppUser implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	public AppUser() {

	};

	public AppUser(String userName) {
		this.userName = userName;

	};
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getLogin() {
		return userName;
	}

	public void setLogin(String userName) {
		this.userName = userName;
	}
}