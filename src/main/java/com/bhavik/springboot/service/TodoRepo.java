package com.bhavik.springboot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhavik.springboot.model.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer> {
	List<Todo> findByUser(String user);
	/*
	 * deleteTodo - Use repository.deleteById(id); instead of repository.delete(id);
	 * showUpdateTodoPage - Use Todo todo = repository.findById(id).get(); instead
	 * of Todo todo = repository.findOne(id);
	 */
}
