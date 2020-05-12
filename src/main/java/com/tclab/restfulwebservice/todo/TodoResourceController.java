package com.tclab.restfulwebservice.todo;


import com.tclab.restfulwebservice.ent.Todo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResourceController {

  private TodoHardCodedService todoService;

  @Autowired
  public TodoResourceController(TodoHardCodedService todoService) {
    this.todoService = todoService;
  }

  @GetMapping("/users/{username}/todos")
  public List<Todo> getAllTodos(@PathVariable String username){
    return todoService.findAll();
  }

  @DeleteMapping("/users/{username}/todos/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id){
    Todo todo = todoService.deleteById(id);

    if (todo != null) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("/users/{username}/todos/{id}")
  public ResponseEntity<Void> updateTodo(@PathVariable String username, @PathVariable int id){
    Todo todo = todoService.deleteById(id);

    if (todo != null) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
