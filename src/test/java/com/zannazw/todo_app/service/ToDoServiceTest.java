package com.zannazw.todo_app.service;

import com.zannazw.todo_app.entity.ToDo;
import com.zannazw.todo_app.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ToDoServiceTest {

    @Autowired
    private ToDoService todoService;

    @MockBean
    private ToDoRepository todoRepository;

    @Test
    void createToDoEquals() {
        ToDo expectedResult = new ToDo("Reinigen", "Pfanne");

        when(todoRepository.save(expectedResult)).thenReturn(expectedResult);
        ToDo actualResult = todoService.createToDo(new ToDo("Reinigen", "Pfanne"));

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void createToDoNotEquals() {
        ToDo expectedResult = new ToDo("Reinigen", "Pfanne");
        ToDo actualInput = new ToDo("Reinigen", "Topf");

        when(todoRepository.save(expectedResult)).thenReturn(actualInput);
        ToDo actualResult = todoService.createToDo(actualInput);

        assertNotEquals(expectedResult, actualResult);
    }

    @Test
    void getAllToDos() {
        List<ToDo> expectedResult = new ArrayList<>();
        ToDo todo1 = new ToDo("Staubsaugen", "Schlafzimmer");
        ToDo todo2 = new ToDo("Einkaufen", "Gurke");
        expectedResult.add(todo1);
        expectedResult.add(todo2);

        when(todoRepository.findAll()).thenReturn(expectedResult);
        List<ToDo> actualResult = todoService.getAllToDos();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getToDoById() {
    }

    @Test
    void getToDoByTitle() {
    }

    @Test
    void updateToDoById() {
    }

    @Test
    void deleteToDoById() {
    }
}