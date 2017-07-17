package com.canh.healthcare.services.interfaces;

import java.util.List;

import com.canh.healthcare.jpa.entity.AppUser;
import com.canh.healthcare.model.AppUserDto;

public interface AuthService {
	
	public void create(AppUserDto appUser);
	public void update(AppUserDto appUser);
	public AppUser checkUser(String userName, String password);
	public List<AppUser> findAll();

}
