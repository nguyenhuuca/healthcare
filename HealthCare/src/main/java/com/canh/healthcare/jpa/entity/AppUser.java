package com.canh.healthcare.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import com.canh.healthcare.model.AppUserDto;

@Entity
@Table(name = "appuser")
@NamedNativeQueries({
		@NamedNativeQuery(name = "findUser", query = " select * from AppUser e where e.userName = :userName and e.user = :password", resultClass = AppUser.class) })
public class AppUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String passUser;
	private String comment;

	public AppUser() {

	};

	public AppUser(AppUserDto appUserDto) {
		if (appUserDto.getId() != null) {
			this.userId = appUserDto.getId();
		}
		this.userName = appUserDto.getUserName();
		this.passUser = appUserDto.getPassUser();
		this.comment = appUserDto.getComment();

	};

	@Column(name = "id")
	public Long getId() {
		return userId;
	}

	public void setId(Long id) {
		this.userId = id;
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