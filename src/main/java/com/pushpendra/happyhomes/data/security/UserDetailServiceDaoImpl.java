package com.pushpendra.happyhomes.data.security;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailServiceDaoImpl implements UserDetailServiceDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void findUserByUserName(String userName) {
		
	}

}
