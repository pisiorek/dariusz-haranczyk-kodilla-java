package com.kodilla.spring.portfolio;

import javafx.concurrent.Task;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class BoardTestSuite {
    @Test
    public  void testTaskAdd(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        //When
        board.addTaskToDoList("Zadanie nr 1 do wykonania");
        board.addTaskinProgressList("Zadanie numer 1 w trakcie wykonywania");
        board.addTaskDoneList("Zadanie numer 1 z wykonanych");
        //Then
        int sizeOfArrayListToDoTask = board.getToDoList().getTask().size();
        int sizeOfArrayListInProgressTask = board.getInProgressList().getTask().size();
        int sizeOfArrayListDoneTask = board.getInProgressList().getTask().size();

        Assert.assertEquals(sizeOfArrayListToDoTask,1);
        Assert.assertEquals(sizeOfArrayListInProgressTask,1);
        Assert.assertEquals(sizeOfArrayListDoneTask,1);
    }
}
