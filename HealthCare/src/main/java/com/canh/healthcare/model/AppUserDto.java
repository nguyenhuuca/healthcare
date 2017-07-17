package com.canh.healthcare.model;

public class AppUserDto {
	private Long id;
	private String userName;
	private String passUser;
	private String comment;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassUser() {
		return passUser;
	}
	public void setPassUser(String passUser) {
		this.passUser = passUser;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
