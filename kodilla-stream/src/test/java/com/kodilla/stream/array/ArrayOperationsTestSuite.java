package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {
    @Test
    public  void testGetAverage(){
        //Given
        int[] numbersArray =  new int[20];

        for (int i=0; i < numbersArray.length; i++){
            numbersArray[i] = i;
        }
        //When
       double expectedValue = ArrayOperations.getAverage(numbersArray);

        //Then
        Assert.assertEquals(9.5, expectedValue,0.1);
    }

}
