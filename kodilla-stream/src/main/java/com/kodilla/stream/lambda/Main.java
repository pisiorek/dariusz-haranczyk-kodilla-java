package com.kodilla.stream.lambda;

public class Main {

    public static void main(String[] args){
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(5,5, (a,b)-> a + b);
    }
}
