package com.kodilla.spring.shape;

import com.kodilla.spring.shape.Shape;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunnerTestSuite {
    @Test
    public void testSquareLoadedIntoContainer() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = context.getBean(Square.class);
        //When
        String name = shape.getShapeName();
        //Then
        Assert.assertEquals("This is a square.", name);
    }
}
