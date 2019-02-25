package com.kodilla.good.patterns.foodtodoor;

public class OrderService {
    public boolean order (final Customer customer, final Supplier supplier, final int productQuantity){
        System.out.println("Your ordered product: " + supplier.getProductName() + " in quantity: "
                + productQuantity + " pieces, " + " from: " + supplier.getCompanyName()
                + " is prepared to sent on address: " + customer.getDeliveryAddress()
                + ". Thank you for transaction and we are looking forward to the future");
        return true;
    }
}
