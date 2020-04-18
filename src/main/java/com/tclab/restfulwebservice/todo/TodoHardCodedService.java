package com.tclab.restfulwebservice.todo;

import com.tclab.restfulwebservice.ent.Todo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {

  private static List<Todo> todos = new ArrayList<>();
  private static int idCounter = 0;

  static{
    todos.add(new Todo(++idCounter, "juan", "learn spring", new Date(), false));
    todos.add(new Todo(++idCounter, "juan", "Exercise", new Date(), false));
    todos.add(new Todo(++idCounter, "juan", "Eat healthy", new Date(), false));
  }

  public List<Todo> findAll(){
    return todos;
  }

  public Todo deleteById(int id){
    Todo todo = findById(id);
    if (todo == null) {
      return null;
    }

    if(todos.remove(todo)) {
      return todo;
    }
     return null;
  }

  public Todo findById(int id) {
    for (Todo todo : todos) {
      if (todo.getId() == id) {
        return todo;
      }
    }
    return null;
  }

}
