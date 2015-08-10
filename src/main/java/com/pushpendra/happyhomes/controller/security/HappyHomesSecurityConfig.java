package com.pushpendra.happyhomes.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.SessionAttributes;

@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = "com.pushpendra.happyhomes")
public class HappyHomesSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/static/**","/signup","/aboutUs","/assets/**").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/home")
			.and()
		.logout().permitAll()
			.and()
		.sessionManagement()
			.invalidSessionUrl("/invalidSession")
			.maximumSessions(3)
			.expiredUrl("/sessionExpired")
			.maxSessionsPreventsLogin(true);
	}
	
	@Autowired
	public void configureGlobal(UserDetailsService userDetailService, AuthenticationManagerBuilder auth, BCryptPasswordEncoder passwordEncoder) throws Exception{
		passwordEncoder = passwordEncoder();
		auth
			.userDetailsService(userDetailService)
				.passwordEncoder(passwordEncoder)
				.and()
			.eraseCredentials(true);
				
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
}
