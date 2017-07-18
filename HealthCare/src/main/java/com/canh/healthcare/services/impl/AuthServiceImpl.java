package com.canh.healthcare.services.impl;

import java.util.List;

import com.canh.healthcare.jpa.entity.AppUser;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.model.AppUserDto;
import com.canh.healthcare.services.BaseSercvices;
import com.canh.healthcare.services.interfaces.AuthService;

public class AuthServiceImpl extends BaseSercvices implements AuthService {

	@Override
	public void create(AppUserDto appUserDto) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		AppUser appUser = new AppUser(appUserDto);
		em.persist(appUser);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void update(AppUserDto appUserDto) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		AppUser appUser = new AppUser(appUserDto);
		em.merge(appUser);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public AppUser checkUser(String userName, String password) {
		em = EntityManagerUtil.getEntityManager();
		AppUser appUser = (AppUser) em.createNamedQuery("findMedicineById")
				.setParameter("userName", userName)
				.setParameter("password", password)
				.getSingleResult();
		return appUser;
	}

	@Override
	public List<AppUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
