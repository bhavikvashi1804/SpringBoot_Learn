package com.bhavik.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bhavik.springboot.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginPage(ModelMap map) {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showWelcomePage(ModelMap map, @RequestParam String name,@RequestParam String password) {
		
		boolean isValidUser = loginService.validateUser(name, password);
		if(isValidUser) {
			map.put("name", name);
			return "welcome";
		}
		else {
			map.put("msg", "Invalid Password");
			return "login";
		}
	}
}
