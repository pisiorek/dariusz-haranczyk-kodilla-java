package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskQueueTestSuite {
    @Test
    public void testUpdate() {
        //Given
        TaskQueue tasksFromModule1 = new TasksFromModule1();
        TaskQueue tasksFromModule2 = new TasksFromModule2();

        Mentor mentor1 = new Mentor("Wojciech Kot");
        Mentor mentor2 = new Mentor("Marcin Mucha");
        Mentor mentor3 = new Mentor("Ewa Bąk");
        Mentor mentor4 = new Mentor("Jacek Placek");

        tasksFromModule1.registerObserver(mentor1);
        tasksFromModule1.registerObserver(mentor2);
        tasksFromModule1.registerObserver(mentor3);
        tasksFromModule1.registerObserver(mentor4);
        tasksFromModule2.registerObserver(mentor1);
        tasksFromModule2.registerObserver(mentor3);

        //When
        tasksFromModule1.sendTaskToCheck("Zadanie do modułu 1.1");
        tasksFromModule1.sendTaskToCheck("Zadanie do modułu 1.2");
        tasksFromModule1.sendTaskToCheck("Zadanie do modułu 1.3");
        tasksFromModule2.sendTaskToCheck("Zadanie do modułu 2.1");
        tasksFromModule2.sendTaskToCheck("Zadanie do modułu 2.2");
        tasksFromModule2.sendTaskToCheck("Zadanie do modułu 2.3");
        tasksFromModule2.sendTaskToCheck("Zadanie do modułu 2.4");

        //Then
        assertEquals(7, mentor1.getUpdateCount());
        assertEquals(3, mentor2.getUpdateCount());
        assertEquals(7, mentor3.getUpdateCount());
        assertEquals(3, mentor4.getUpdateCount());
    }
}
