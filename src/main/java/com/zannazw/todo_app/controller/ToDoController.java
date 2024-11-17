package com.zannazw.todo_app.controller;

import com.zannazw.todo_app.entity.ToDo;
import com.zannazw.todo_app.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    ToDoService todoService;

    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<ToDo> getAllToDos() {
        return todoService.getAllToDos();
    }

    @GetMapping("/{title}")
    public ToDo getToDo(@PathVariable String title) {
        ToDo todo = todoService.getToDoByTitle(title)
                .orElseThrow(() -> new NoSuchElementException(String.format("No Todo found with title: %s", title)));
        return todo;
    }

    @PostMapping("/create")
    public ToDo newToDo(@RequestBody ToDo todo) {
        return todoService.createToDo(todo);
    }

    @PutMapping("/edit/{id}")
    public ToDo updateToDo(@PathVariable int id, @RequestBody ToDo todo) {
        ToDo toDo = todoService.updateToDoById(id, todo)
                .orElseThrow(() -> new NoSuchElementException(String.format("No Todo found with id: %s", id)));
        return todo;
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable int id) {
        todoService.deleteToDoById(id);
    }
}
