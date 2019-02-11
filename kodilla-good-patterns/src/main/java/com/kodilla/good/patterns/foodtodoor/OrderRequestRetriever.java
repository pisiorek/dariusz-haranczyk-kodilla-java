package com.kodilla.good.patterns.foodtodoor;

public class OrderRequestRetriever {

    public OrderRequest retrieve(SupplierDatabase supplierDatabase){

        Customer customer = new Customer("Ewa", "Kot", "Adres 1");
        Supplier supplier = supplierDatabase.getSupplier(1);
        int productQuantity = 5;

        return new OrderRequest(customer, supplier, productQuantity);
    }
}
