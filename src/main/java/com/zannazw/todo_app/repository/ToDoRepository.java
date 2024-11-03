package com.zannazw.todo_app.repository;

import com.zannazw.todo_app.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    //Create & Update
    //void save(ToDo todo);

    //Read
    //List<ToDo> findAll();

    //Optional<ToDo> findById(int id);

    Optional<ToDo> findByTitle(String title);

    //Delete
    //void deleteById(int id);

    void deleteByTitle(String title);


}
