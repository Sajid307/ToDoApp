package com.learn.app;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ToDo {

	@Id
	private Integer todoId;
	private String task;
	private String description;
	private LocalDate dateOfCompletion;
	private boolean status;

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateOfCompletion() {
		return dateOfCompletion;
	}

	public void setDateOfCompletion(LocalDate dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ToDo(int todoId, String task, String description, LocalDate dateOfCompletion, boolean status) {
		super();
		this.todoId = todoId;
		this.task = task;
		this.description = description;
		this.dateOfCompletion = dateOfCompletion;
		this.status = status;
	}

	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "todoapp [todoId=" + todoId + ", task=" + task + ", description=" + description + ", dateOfCompletion="
				+ dateOfCompletion + ", status=" + status + "]";
	}

}
