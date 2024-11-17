package com.zannazw.todo_app.service;

import com.zannazw.todo_app.entity.ToDo;
import com.zannazw.todo_app.repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ToDoServiceTest {

    @Autowired
    private ToDoService todoService;

    @MockBean
    private ToDoRepository todoRepository;

    @Test
    void createToDo_Equals() {
        ToDo input = new ToDo("Reinigen", "Pfanne");
        ToDo expectedResult = new ToDo("Reinigen", "Pfanne");

        when(todoRepository.save(input)).thenReturn(expectedResult);
        ToDo actualResult = todoService.createToDo(input);

        assertEquals(expectedResult, actualResult);
        verify(todoRepository).save(input);
    }

    @Test
    void createTo_DoNotEquals() {
        ToDo input = new ToDo("Reinigen", "Pfanne");
        ToDo expectedResult = new ToDo("Reinigen", "Topf");

        when(todoRepository.save(input)).thenReturn(expectedResult);
        ToDo actualResult = todoService.createToDo(input);

        assertNotEquals(expectedResult, actualResult);
        verify(todoRepository).save(input);
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
        int input = 3;
        Optional<ToDo> expectedResult = Optional.of(new ToDo("Waschen", "Bettbezug"));

        when(todoRepository.findById(input)).thenReturn(expectedResult);
        Optional<ToDo> actualResult = todoService.getToDoById(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getToDoByTitle() {
        String input = "Kochen";
        Optional<ToDo> expectedResult = Optional.of(new ToDo("Kochen", "Suppe"));

        when(todoRepository.findByTitle(input)).thenReturn(expectedResult);
        Optional<ToDo> actualResult = todoService.getToDoByTitle(input);

        assertTrue(actualResult.isPresent());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void updateToDoById() {
        int input = 3;
        ToDo newTodo = new ToDo("Kochen", "Kartoffel-Suppe");

        ToDo oldTodo = new ToDo("Kochen", "Suppe");
        Optional<ToDo> expectedResult = Optional.of(oldTodo);

        when(todoRepository.findById(input)).thenReturn(expectedResult);
        when(todoRepository.save(oldTodo)).thenReturn(oldTodo);

        Optional<ToDo> actualResult = todoService.updateToDoById(input, newTodo);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deleteToDoById() {
        int input = 3;
        todoService.deleteToDoById(input);
        verify(todoRepository).deleteById(input);
    }
}