package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double addResult = calculator.add(5,5);
        double subResult = calculator.sub(5,5);
        double mulResult = calculator.mul(5,5);
        double divResult = calculator.div(5,5);
        //Then
        Assert.assertEquals(addResult,10,0.1);
        Assert.assertEquals(subResult,0,0.1);
        Assert.assertEquals(mulResult,25,0.1);
        Assert.assertEquals(divResult,1,0.1);
    }
}
