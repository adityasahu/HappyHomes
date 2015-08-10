package com.pushpendra.happyhomes.data.security;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailServiceDao {
	void findUserByUserName(String userName);
}
