package com.learn.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ToDoService {
	
	@Autowired
	private ToDoRepository toDoRepo;
	
	public Flux<ToDo> findAllTasks() {
		return toDoRepo.findAll();
	}
	
	public void createTask(ToDo todo) {
		toDoRepo.save(todo).subscribe();
	}
	
	public Mono<ToDo> findById(Integer todoId) {
		return toDoRepo.findById(todoId);
	}
	
	public Mono<Void> deleteById(Integer todoId) {
		return toDoRepo.deleteById(todoId);
	}
	
	public Mono<ToDo> update(Integer todoId, ToDo todo) {
		return toDoRepo.findById(todoId)
				.flatMap(existingTask -> {
					existingTask.setTask(todo.getTask());
					existingTask.setDescription(todo.getDescription());
					existingTask.setDateOfCompletion(todo.getDateOfCompletion());
					existingTask.setStatus(false);
					
					return toDoRepo.save(existingTask);
				});
	}
}
