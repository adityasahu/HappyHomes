package com.pushpendra.happyhomes.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pushpendra.happyhomes.data.security.UserDetailServiceDao;

@Service
public class UserDetailServicesImpl implements UserDetailServices {
	
	
	@Autowired
	private UserDetailServiceDao userDetailServiceDao;
	
	@Override
	public void findUserByUserId(String userName) {
		userDetailServiceDao.findUserByUserName(userName);
	}

}
