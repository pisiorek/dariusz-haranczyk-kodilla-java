package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName){
        this.mentorName = mentorName;
    }

    @Override
    public void update(TaskQueue taskQueue){
        System.out.println(mentorName + ": Hello, you have got the tasks to check: " + taskQueue.getName() + "\n" +
                " (total " + taskQueue.getTaskName().size() + " task(s)");
        updateCount++;

    }
    public String getMentorName(){
        return mentorName;
    }

    public int getUpdateCount(){
        return updateCount;
    }
}
