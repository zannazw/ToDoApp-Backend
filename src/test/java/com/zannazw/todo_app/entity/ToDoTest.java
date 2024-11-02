package com.zannazw.todo_app.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToDoTest {

    private ToDo toDo;

    @BeforeEach
    void setUp() {
        toDo = new ToDo("Putzen", "Badezimmer");
    }

    @Test
    void setId() {
        int expectedResult = 2;
        toDo.setId(expectedResult);
        int actualResult = toDo.getId();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void setTitle() {
        //given
        String expectedResult = "Reinigen";
        toDo.setTitle(expectedResult);
        String actualResult;

        //when
        actualResult = toDo.getTitle();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void setDescription() {
        String expectedResult = "Pfannen";
        toDo.setDescription(expectedResult);
        String actualResult = toDo.getDescription();
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
        actualResult = toDo.getTitle();

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getDescription() {
        String expectedResult = "Badezimmer";
        String actualResult = toDo.getDescription();
        assertEquals(expectedResult, actualResult);
    }
}