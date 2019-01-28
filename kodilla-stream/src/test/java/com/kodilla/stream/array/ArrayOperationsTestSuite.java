package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalDouble;

public class ArrayOperationsTestSuite {
    @Test
    public  void testGetAverage(){
        //Given
        int[] numbersArray =  new int[4];

        for (int i=0; i < numbersArray.length; i++){
            numbersArray[i] = i;
        }
        //When
       OptionalDouble expectedValue = ArrayOperations.getAverage(numbersArray);

        //Then
        Assert.assertEquals(1.5, expectedValue);
    }

}
