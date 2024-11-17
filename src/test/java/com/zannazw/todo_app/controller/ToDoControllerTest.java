package com.zannazw.todo_app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllToDos() throws Exception {
        //mockMvc.perform(get("/todo")).andExpect(status().isOk());
    }

    @Test
    void getToDo() {
    }

    @Test
    void newToDo() {
    }

    @Test
    void updateToDo() {
    }

    @Test
    void deleteToDo() {
    }
}