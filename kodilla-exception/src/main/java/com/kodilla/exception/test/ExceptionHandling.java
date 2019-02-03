package com.kodilla.exception.test;

import java.time.LocalDate;

public class ExceptionHandling {
    public static void main(String []args){
        SecondChallenge secondChallenge = new SecondChallenge();
        try{
            secondChallenge.probablyIWillThrowException(1.5,1.5);
        }catch (Exception e){
            System.out.println("Błąd zakresu argumentów " + e);
        }finally {
            LocalDate localDate = LocalDate.now();
            System.out.println("Data wykonania działania " + localDate);
    }
    }
}
