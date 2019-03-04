package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Tasks {

    private final String taskName;
    private final String where;
    private final String using;
    private boolean isTaskExecuted;

    public DrivingTask(String taskName, String where, String using){
        this.taskName = taskName;
        this.where = where;
        this. using = using;
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }

    @Override
    public String getTaskName(){
        return  taskName;
    }

    @Override
    public boolean isTaskExecuted(){
        return isTaskExecuted;
    }
    @Override
    public void executeTask(){
        System.out.println("Kurs do " + getWhere() + " wykonano używając pojazdu: " + getUsing());
        isTaskExecuted = true;
    }
}
