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
        @Test
        public void testPizzaWithMushroomsCost(){
            //Given
            PizzaOrder pizzaOrder = new BasicPizzaOrder();
            pizzaOrder = new MushroomsDecorator(pizzaOrder);

            //When
            BigDecimal theCost = pizzaOrder.getCost();

            //Then
            assertEquals(new BigDecimal(20), theCost);
        }

    @Test
    public void testPizzaWithMushroomsIngredients(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        //When
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals("Thin pizza with tomato sauce and cheese + mushrooms", ingredients);
    }

    @Test
    public void testPizzaWitAllIngredientsCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new TunfishDecorator(pizzaOrder);
        pizzaOrder = new SeaFoodsDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(38), theCost);
    }
    @Test
    public void testPizzaWithAllIngredients(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new TunfishDecorator(pizzaOrder);
        pizzaOrder = new SeaFoodsDecorator(pizzaOrder);

        //When
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals("Thin pizza with tomato sauce and cheese + mushrooms + tunfish + sea food", ingredients);
    }
}
