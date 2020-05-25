package com.tclab.restfulwebservice.todo;

import com.tclab.restfulwebservice.ent.Todo;
import com.tclab.restfulwebservice.repo.TodoJpaRepository;
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

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJpaResourceController {

  private TodoHardCodedService todoService;
  private TodoJpaRepository todoJpaRepository;

  @Autowired
  public TodoJpaResourceController(
      TodoHardCodedService todoService,
      TodoJpaRepository todoJpaRepository
  ) {
    this.todoService = todoService;
    this.todoJpaRepository = todoJpaRepository;
  }

  @GetMapping("/jpa/users/{username}/todos")
  public List<Todo> getAllTodos(@PathVariable String username) {
    return todoJpaRepository.findByUsername(username);
  }

  @GetMapping("/jpa/users/{username}/todos/{id}")
  public Todo getTodoById(@PathVariable String username, @PathVariable long id) {
    return todoJpaRepository.findById(id).get();
  }

  @DeleteMapping("/jpa/users/{username}/todos/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
    todoJpaRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/jpa/users/{username}/todos")
  public ResponseEntity<Todo> updateTodo(@PathVariable String username, @RequestBody Todo todo) {
    todo.setUsername(username);
    Todo todoUpdated = todoJpaRepository.save(todo);
    return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
  }

  @PostMapping("/jpa/users/{username}/todos")
  public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
    todo.setUsername(username);
    Todo createdTodo = todoJpaRepository.save(todo);
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdTodo.getId())
            .toUri();

    return ResponseEntity.created(uri).build();
  }
}
