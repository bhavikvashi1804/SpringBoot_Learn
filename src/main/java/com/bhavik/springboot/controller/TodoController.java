package com.bhavik.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bhavik.springboot.model.Todo;
import com.bhavik.springboot.service.TodoRepo;
import com.bhavik.springboot.service.TodoService;


@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService service;
	@Autowired
	TodoRepo repo;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String showToDoListPage(ModelMap map) {
		
		String userName = getUserName(map);
		map.put("todos", service.retrieveTodos(userName));
		return "list-todos";
	}

	private String getUserName(ModelMap map) {
		return (String) map.get("name");
	}
	
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String addNewTodoPage(ModelMap map) {
		map.addAttribute("todo", new Todo(0, getUserName(map), "", new Date(), false));
		return "todo";
	}
	
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addNewTodoToCollection(ModelMap map,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		//set the username of todo
		todo.setUser(getUserName(map));
		//save that todo
		repo.save(todo);
		//String userName = getUserName(map);
		//service.addTodo(userName, todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
	
	
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteTodoFromCollection(ModelMap map, @RequestParam int id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String updateTodoShowPage(ModelMap map, @RequestParam int id) {
		Todo todo = service.getTodo(id);
		map.put("todo", todo);
		return "todo";
	}
	
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodoINCollection(ModelMap map,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getUserName(map));
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}
}
