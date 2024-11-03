package com.zannazw.todo_app.service;

import com.zannazw.todo_app.entity.ToDo;
import com.zannazw.todo_app.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository todoRepository;

    public ToDo createToDo(ToDo toDo) {
        return todoRepository.save(toDo);
    }

    public List<ToDo> getAllToDos() {
        return todoRepository.findAll();
    }

    public Optional<ToDo> getToDoById(int id) {
        return todoRepository.findById(id);
    }

    public Optional<ToDo> getToDoByTitle(String title) {
        return todoRepository.findByTitle(title);
    }

    public Optional<ToDo> updateToDoById(int id, ToDo newToDo) {
        return todoRepository.findById(id)
                .map(oldToDo -> {
                    oldToDo.setTitle(newToDo.getTitle());
                    oldToDo.setDescription(newToDo.getDescription());
                    return todoRepository.save(oldToDo);
                });
    }

    public void deleteToDoById(int id) {
        todoRepository.deleteById(id);
    }

}
