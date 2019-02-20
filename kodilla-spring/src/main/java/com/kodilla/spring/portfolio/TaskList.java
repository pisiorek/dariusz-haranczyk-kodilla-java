package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public final class TaskList extends ArrayList {

    private List<String> tasks;

    public TaskList(){
        this.tasks = new ArrayList<String>();
    }

    public void addTask(String addTask){
        this.tasks.add(addTask);
    }

    public List<String> getTask(){
        return  this.tasks;
    }

    public void showTasks(){
        for(int i = 0; i < tasks.size(); i++){
            System.out.println(tasks.get(i));
        }
    }
}
