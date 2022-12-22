package org.seven.telecom.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import org.seven.telecom.domain.User;

public interface IUserService {

	List<User> findAll();

	User findByUserName(String username);

	User createNewUser(User user);
	
	boolean isUsernameExist(String username);
	
	UserDetails loadUserByUsername(String username);

}
