package com.canh.healthcare.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appuser")
public class AppUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String passUser;
	private String comment;

	public AppUser() {

	};

	public AppUser(String userName, String pass, String comment) {
		this.userName = userName;
		this.passUser = pass;
		this.comment = comment;

	};

	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "pass_user")
	public String getPassUser() {
		return passUser;
	}

	public void setPassUser(String password) {
		this.passUser = password;
	}

	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}