package com.canh.healthcare.services.interfaces;

import java.util.List;

import com.canh.healthcare.jpa.entity.AppUser;
import com.canh.healthcare.model.AppUserDto;
import com.canh.healthcare.utils.ResultInfo;

public interface AuthService {
	
	public ResultInfo create(AppUserDto appUser);
	public ResultInfo update(AppUserDto appUser);
	public AppUser checkUser(String userName, String password);
	public List<AppUser> findAll();

}
