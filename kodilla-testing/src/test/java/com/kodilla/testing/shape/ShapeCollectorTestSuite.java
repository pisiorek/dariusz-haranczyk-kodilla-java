package com.kodilla.testing.shape;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @After
    public void afterEveryTest(){
        System.out.println("Finish to execute test #" + testCounter);
    }

    //test sprawdza czy element został dodany do listy
    @Test
    public void testAddFigureToList(){
        //Given
        ShapeCollector figure = new ShapeCollector();

        //When
        figure.addFigure(new Square("Kwadrat",10,10));
        //figure.getListQuantity()

        //Then
        Assert.assertEquals(1,figure.getListQuantity());
    }
    //test sprawdza czy element dodany do listy ma właściwą nazwę
    @Test
    public void testTheShapeName(){
        //Given
        ShapeCollector figure = new ShapeCollector();

        //When
        figure.addFigure(new Square("Kwadrat",10,10));
        String shapeName = figure.shapeList.get(0).getShapeName();

        //Then
        Assert.assertEquals("Kwadrat",shapeName);
    }

    //test najpierw dodaje element do listy po czym go usuwa i sprawdza czy lista jest pusta
    @Test
    public void testRemovingElementOfList(){
        //Given
        ShapeCollector figure = new ShapeCollector();
        figure.addFigure(new Triangle("Trójkąt", 10, 20));

        //When

        figure.removeFigure(figure.shapeList.get(0));

        //Then
        Assert.assertEquals(0,figure.shapeList.size());
    }

    //test porównujacy obiekty dodane do listy
    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector figure = new ShapeCollector();
        figure.addFigure(new Triangle("Trójkąt", 10, 30));

        //When
        Shape figureTested =  figure.getFigure(0);

        //Then
        Assert.assertEquals(figure.shapeList.get(0).getClass(),figureTested.getClass());

    }


}
