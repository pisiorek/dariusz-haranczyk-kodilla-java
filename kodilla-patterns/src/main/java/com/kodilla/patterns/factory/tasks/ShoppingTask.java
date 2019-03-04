package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Tasks {

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isTaskExecuted;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    public String getWhatToBuy(){
        return whatToBuy;
    }

    public double getQuantity() {
        return quantity;
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
        System.out.println("Zamówiono: " + getWhatToBuy() + " w ilości " + getQuantity() + " szt.");
        isTaskExecuted = true;
    }


}
