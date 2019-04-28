package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;
import static org.junit.Assert.*;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        BigDecimal theCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(15), theCost);
    }
    @Test
    public void testBasicPizzaIngredients(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals("Thin pizza with tomato sauce and cheese", ingredients);
    }
}
