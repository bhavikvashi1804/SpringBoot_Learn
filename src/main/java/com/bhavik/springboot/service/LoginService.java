package com.bhavik.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String name,String password) {
		if(name.equals("bhavik") && password.equals("vashi")) {
			return true;
		}
		return false;
	}
	
}
