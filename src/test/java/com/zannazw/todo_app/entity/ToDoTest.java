package com.zannazw.todo_app.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDoTest {

    private ToDo todo;

    @BeforeEach
    void setUp() {
        todo = new ToDo("Putzen", "Badezimmer");
    }

    @Test
    void setId() {
        int expectedResult = 2;
        todo.setId(expectedResult);
        int actualResult = todo.getId();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void setTitle() {
        //given
        String expectedResult = "Reinigen";
        todo.setTitle(expectedResult);
        String actualResult;

        //when
        actualResult = todo.getTitle();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void setDescription() {
        String expectedResult = "Pfannen";
        todo.setDescription(expectedResult);
        String actualResult = todo.getDescription();
        assertEquals(expectedResult, actualResult);
    }

/*    @Test
    void getId() {
        int expectedResult = 1;
        int actualResult = toDo.getId();
        assertEquals(expectedResult, actualResult);
    }*/

    @Test
    void getTitle() {
        //given
        String expectedResult = "Putzen";
        String actualResult;

        //when
        actualResult = todo.getTitle();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getDescription() {
        String expectedResult = "Badezimmer";
        String actualResult = todo.getDescription();
        assertEquals(expectedResult, actualResult);
    }
}