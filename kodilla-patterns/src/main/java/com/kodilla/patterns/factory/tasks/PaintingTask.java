package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Tasks {

    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean isTaskExecuted;

    public PaintingTask(String taskName, String color, String whatToPaint){
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    public String getColor() {
        return color;
    }

    public String getWhatToPaint() {
        return whatToPaint;
    }

    @Override
    public String getTaskName(){
        return  taskName;
    }

    @Override
    public boolean isTaskExecuted(){
        System.out.println("Zadanie " + "[" + getTaskName()+ "] " + " zostało wykonane.");
        return isTaskExecuted;
    }
    @Override
    public void executeTask(){
        System.out.println("Zlecono pomalowanie: " + getWhatToPaint() + " na kolor " + getColor());
        isTaskExecuted = true;
    }
}
