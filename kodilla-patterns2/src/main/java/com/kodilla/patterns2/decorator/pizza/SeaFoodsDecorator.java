package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SeaFoodsDecorator extends AbstractPizzaOrderDecorator{
    public SeaFoodsDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(10));
    }
    @Override
    public String getIngredients(){
        return super.getIngredients() + " + sea food";
    }
}
