package com.kodilla.testing;


import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        int addResult = Calculator.add(2,2);
        int subResult = Calculator.subtract( 5,3);

        if(addResult == 4){
            System.out.println("Test dodawania OK");
        }else{

            System.out.println("Test dodawania zwraca niepoprawny wynik");
        }

        if(subResult == 2){
            System.out.println("Test odejmowania OK");
        }else{

            System.out.println("Test odejmowania zwraca niepoprawny wynik");
        }
    }
}