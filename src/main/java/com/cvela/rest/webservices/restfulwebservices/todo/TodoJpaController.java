package com.cvela.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cvela.rest.webservices.restfulwebservices.todo.Todo;

/**
 * Todo JPA Application Controller.
 * @author cvela
 *
 */
@CrossOrigin("http://localhost:4200")
@RestController
public class TodoJpaController {
	
	@Autowired
	private TodoHardcodedService todoService;
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;

	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		//return todoService.findAll(); // Hardcoded service
		return todoJpaRepository.findByUsername(username);
	}
	
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,
			@PathVariable long id) {
		//return todoService.findById(id);	
		return todoJpaRepository.findById(id).get();	
	}
	
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> saveTodo(@PathVariable String username,
			@RequestBody Todo todo) {
		//todoService.save(todo);
		todo.setUsername(username);
		todoJpaRepository.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Void> updateTodo(@PathVariable String username,
			@PathVariable long id, @RequestBody Todo todo) {
		// Todo createdTodo = todoService.save(todo);
		Todo createdTodo = todoJpaRepository.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,
			@PathVariable long id) {
		// Todo todo = todoService.deleteById(id);
		todoJpaRepository.deleteById(id);
		
		//if (todo != null) return ResponseEntity.noContent().build();
		return ResponseEntity.noContent().build();
		//return ResponseEntity.notFound().build();
	}
}
