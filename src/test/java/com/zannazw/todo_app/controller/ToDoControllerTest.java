package com.zannazw.todo_app.controller;

import com.zannazw.todo_app.entity.ToDo;
import com.zannazw.todo_app.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ToDoController.class)
class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService todoService;

    @Test
    void getAllToDos() throws Exception {
        ToDo todo1 = new ToDo("Programmieren", "Backend");
        ToDo todo2 = new ToDo("Test schreiben", "Controller");
        Mockito.when(todoService.getAllToDos()).thenReturn(List.of(todo1, todo2));

        mockMvc.perform(get("/todo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Programmieren"))
                .andExpect(jsonPath("$[0].description").value("Backend"))
                .andExpect(jsonPath("$[1].title").value("Test schreiben"))
                .andExpect(jsonPath("$[1].description").value("Controller"));
    }

    @Test
    void getAllToDos_NoContent() throws Exception {
        Mockito.when(todoService.getAllToDos()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/todo"))
                .andExpect(status().isNoContent());
    }

    @Test
    void getToDo() throws Exception {
        Optional<ToDo> todo = Optional.of(new ToDo("Podcast hören", "Baywatch Berlin"));
        String title = "Podcast hören";
        Mockito.when(todoService.getToDoByTitle(title)).thenReturn(todo);

        mockMvc.perform(get("/todo/{title}", title))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Podcast hören"))
                .andExpect(jsonPath("$.description").value("Baywatch Berlin"));
    }

    @Test
    void newToDo() throws Exception {
        ToDo todo = new ToDo("Morgen klären", "Betreuung");
        Mockito.when(todoService.createToDo(todo)).thenReturn(todo);

        mockMvc.perform(post("/todo/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Morgen klären\",\"description\":\"Betreuung\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Morgen klären"))
                .andExpect(jsonPath("$.description").value("Betreuung"));
    }

    @Test
    void updateToDo() throws Exception {
        int id = 1;
        ToDo todo = new ToDo("Tickets buchen", "Konzert");
        Mockito.when(todoService.updateToDoById(id, todo)).thenReturn(Optional.of(todo));

        mockMvc.perform(put("/todo/edit/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Tickets buchen\",\"description\":\"Konzert\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Tickets buchen"))
                .andExpect(jsonPath("$.description").value("Konzert"));
    }

    @Test
    void deleteToDo() throws Exception {
        int id = 1;
        Mockito.doNothing().when(todoService).deleteToDoById(id);

        mockMvc.perform(delete("/todo/{id}", id))
                .andExpect(status().isNoContent());
    }
}
