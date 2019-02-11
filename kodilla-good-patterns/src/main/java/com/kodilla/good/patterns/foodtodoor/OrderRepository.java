package com.kodilla.good.patterns.foodtodoor;

public interface OrderRepository {
    boolean createOrder(OrderRequest orderRequest);
}
