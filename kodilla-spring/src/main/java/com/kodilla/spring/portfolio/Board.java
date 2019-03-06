package com.kodilla.spring.portfolio;

import java.util.ArrayList;

public final class Board {

    private TaskList toDoList;
    private TaskList inProgressList ;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList){
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addTaskToDoList(String taskToDoList){
        toDoList.addTask(taskToDoList);
        toDoList.showTasks();
    }
    public void addTaskInProgressList(String taskInProgressList){
        inProgressList.addTask(taskInProgressList);
        inProgressList.showTasks();
    }
    public void addTaskDoneList(String taskDoneList){
        doneList.addTask(taskDoneList);
        doneList.showTasks();
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

}
