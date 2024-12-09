package com.zannazw.todo_app.controller;

import com.zannazw.todo_app.entity.ToDo;
import com.zannazw.todo_app.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    ToDoService todoService;

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDos() {
        List<ToDo> todos = todoService.getAllToDos();
        if (todos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{title}")
    public ResponseEntity<ToDo> getToDo(@PathVariable String title) {
        Optional<ToDo> todo = todoService.getToDoByTitle(title);
        if (todo.isPresent()) {
            return ResponseEntity.ok(todo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ToDo> newToDo(@RequestBody ToDo todo) {
        ToDo createdTodo = todoService.createToDo(todo);
        return ResponseEntity.ok(createdTodo);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable int id, @RequestBody ToDo todo) {
        Optional<ToDo> updatedTodo = todoService.updateToDoById(id, todo);
        if (updatedTodo.isPresent()) {
            return ResponseEntity.ok(updatedTodo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable int id) {
        todoService.deleteToDoById(id);
        return ResponseEntity.noContent().build();
    }
}
