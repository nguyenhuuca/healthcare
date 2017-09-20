package com.canh.healthcare.services.impl;

import java.util.List;

import com.canh.healthcare.jpa.entity.AppUser;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.model.AppUserDto;
import com.canh.healthcare.services.BaseSercvices;
import com.canh.healthcare.services.interfaces.AuthService;
import com.canh.healthcare.utils.Constants;
import com.canh.healthcare.utils.ResultInfo;

public class AuthServiceImpl extends BaseSercvices implements AuthService {

	private static AuthService authService;

	private AuthServiceImpl() {

	}

	public static AuthService getInstance() {
		if (authService == null) {
			authService = new AuthServiceImpl();
		}
		return authService;
	}

	@Override
	public ResultInfo create(AppUserDto appUserDto) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			AppUser appUser = new AppUser(appUserDto);
			em.persist(appUser);
			em.getTransaction().commit();
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
		} catch (Exception e) {
			em.getTransaction().rollback();
			resultInfo.setMesssage(e.getMessage());
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
		}
		return resultInfo;
	}

	@Override
	public ResultInfo update(AppUserDto appUserDto) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			AppUser appUser = new AppUser(appUserDto);
			em.merge(appUser);
			em.getTransaction().commit();
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
		} catch (Exception e) {
			em.getTransaction().rollback();
			resultInfo.setMesssage(e.getMessage());
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
		}
		return resultInfo;
	}

	@Override
	public AppUser checkUser(String userName, String password) {
		em = EntityManagerUtil.getEntityManager();
		AppUser appUser = (AppUser) em.createNamedQuery("findMedicineById").setParameter("userName", userName)
				.setParameter("password", password).getSingleResult();
		return appUser;
	}

	@Override
	public List<AppUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
