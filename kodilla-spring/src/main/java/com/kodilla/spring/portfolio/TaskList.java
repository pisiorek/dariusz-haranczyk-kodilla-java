package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<String> tasks;

    @Autowired
    public TaskList(){
        this.tasks = new ArrayList<String>();
        }

}
