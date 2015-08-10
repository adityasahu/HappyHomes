package com.pushpendra.happyhomes.controller.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pushpendra.happyhomes.services.security.UserDetailServices;
import com.pushpendra.happyhomes.utilities.HappyHomesConstants;

@Controller
public class UserdetailsController implements UserDetailsService {
	
	@Autowired
	private UserDetailServices userDetailServices;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		return null;
	}
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse responce){
		return HappyHomesConstants.LOGIN;
	}

}
