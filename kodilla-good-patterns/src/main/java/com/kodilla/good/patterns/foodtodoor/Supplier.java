package com.kodilla.good.patterns.foodtodoor;

public interface Supplier {

    //void Supplier(String companyName, String productName, int quantity);
     OrderDto process(final OrderRequest orderRequest);
     String getProductName();
     String getCompanyName();

}
