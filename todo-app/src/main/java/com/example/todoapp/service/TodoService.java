package com.example.todoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.entity.TodoItem;
import com.example.todoapp.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepo;

	public List<TodoItem> getAllTodoItems() {
		return todoRepo.findAll();
	}

	public TodoItem updateTodoItem(Long id, TodoItem todoItem) {
		Optional<TodoItem> todoOpt = todoRepo.findById(id);
		
		if (todoOpt.isPresent()) {
			TodoItem item = todoOpt.get();
			item.setIsDone(todoItem.getIsDone());
			item.setTask(todoItem.getTask());
			todoRepo.save(item);
			return item;
		}
		return null;
	}

	public TodoItem createTodoItem() {
		TodoItem todoItem = new TodoItem();

		todoItem.setIsDone(false);
		todoItem = todoRepo.save(todoItem);
		todoItem.setTask("- - - Buraya Yazın - - -");
		return todoItem;
	}

	public void deleteTodoItem(Long id) {
		todoRepo.deleteById(id);
		
	}
}
