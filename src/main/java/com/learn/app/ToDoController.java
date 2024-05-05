package com.learn.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/todo")
public class ToDoController {
	
	@Autowired
	private ToDoService todoservice;
	
	@GetMapping()
	public Flux<ToDo> getAllTasks() {
		return todoservice.findAllTasks();
	}
	
	@PostMapping("/create")
	public void createTask(@RequestBody ToDo todo) {
		todoservice.createTask(todo);
	}
	
	@GetMapping("/{todoId}")
	public Mono<ToDo> findTodoById(@PathVariable Integer todoId) {
		return todoservice.findById(todoId);
	}
	
	@DeleteMapping("/delete/{todoId}")
	public Mono<Void> deleteById(@PathVariable Integer todoId) {
		return todoservice.deleteById(todoId);
	}
	
	@PutMapping("/update/{todoId}")
	public Mono<ToDo> update(@PathVariable Integer todoId, @RequestBody ToDo todo) {
		return todoservice.update(todoId, todo);
	}
}
