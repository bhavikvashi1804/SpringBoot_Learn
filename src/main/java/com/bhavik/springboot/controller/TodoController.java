package com.bhavik.springboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bhavik.springboot.service.TodoService;


@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService service;
	

	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String showLoginPage(ModelMap map) {
		
		String userName = (String) map.get("name");
		map.put("todos", service.retrieveTodos(userName));
		return "list-todos";
	}
	
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String addNewTodoPage(ModelMap map) {
		
		return "todo";
	}
	
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addNewTodoToCollection(ModelMap map, @RequestParam String desc) {
		String userName = (String) map.get("name");
		service.addTodo(userName, desc, new Date(), false);
		return "redirect:/list-todos";
	}
}
