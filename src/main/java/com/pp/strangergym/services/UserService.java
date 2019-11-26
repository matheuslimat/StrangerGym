	package com.pp.strangergym.services;


import org.springframework.security.core.context.SecurityContextHolder;

import com.pp.strangergym.security.UserSecutiry;

public class UserService {
	
	public static UserSecutiry authenticated() {
		try {
			return (UserSecutiry) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
