package com.pushpendra.happyhomes.services.security;

import org.springframework.stereotype.Service;

@Service
public interface UserDetailServices {
	
	void findUserByUserId(String userName);
}
