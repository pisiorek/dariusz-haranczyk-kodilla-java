package com.kodilla.good.patterns.foodtodoor;

public class OrderDatabase implements OrderRepository{
    @Override
    public boolean createOrder(OrderRequest orderRequest) {
        System.out.println("Order has been added to OrderDatabase");
        return false;
    }
}
