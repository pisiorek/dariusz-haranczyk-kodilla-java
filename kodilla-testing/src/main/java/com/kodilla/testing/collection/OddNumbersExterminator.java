package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers){

        ArrayList<Integer> oddList = new ArrayList<Integer>(); //lista dla liczb parzystych

        for(Integer listElements: numbers){
            if(listElements % 2 == 0){
                oddList.add(listElements);
            }
        }

        return oddList;
    }
}
