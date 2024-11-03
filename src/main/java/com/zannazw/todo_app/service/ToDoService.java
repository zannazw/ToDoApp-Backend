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
    private ToDoRepository toDoRepository;

    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> getToDoById(int id) {
        return toDoRepository.findById(id);
    }

    public Optional<ToDo> getToDoByTitle(String title) {
        return toDoRepository.findByTitle(title);
    }

    public Optional<ToDo> updateToDoById(int id, ToDo newToDo) {
        return toDoRepository.findById(id)
                .map(oldToDo -> {
                    oldToDo.setTitle(newToDo.getTitle());
                    oldToDo.setDescription(newToDo.getDescription());
                    return toDoRepository.save(oldToDo);
                });
    }

    public void deleteToDoById(int id) {
        toDoRepository.deleteById(id);
    }

}
