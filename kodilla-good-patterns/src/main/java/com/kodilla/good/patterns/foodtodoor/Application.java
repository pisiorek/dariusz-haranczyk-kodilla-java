package com.kodilla.good.patterns.foodtodoor;

public class Application {
    public static  void main(String []args) {

        SupplierDatabase supplierDatabase = new SupplierDatabase();

        Supplier supplier = new HealthyShopSupplier(new MailService(), new OrderService(), new OrderDatabase(),"Buraki","Healthy Shop");
        Supplier supplier1 = new ExtraFoodShopSupplier(new MailService(), new OrderService(), new OrderDatabase(), "Pomidory", "Extra Food Shop" );
        Supplier supplier2 = new GlutenFreeShopSupplier(new MailService(),new OrderService(), new OrderDatabase(), "Makaron", "Gluten Free Shop");

        supplierDatabase.addSupplier(supplier);
        supplierDatabase.addSupplier(supplier1);
        supplierDatabase.addSupplier(supplier2);

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve(supplierDatabase);

        supplier1.process(orderRequest);
    }
}
