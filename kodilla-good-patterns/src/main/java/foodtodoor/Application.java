package foodtodoor;

public class Application {
    public static  void main(String []args) {

        SupplierDatabase supplierDatabase = new SupplierDatabase();
        Supplier supplier1 = new Supplier("ExtraFoodShop","Nabiał");
        Supplier supplier2 = new Supplier("HealthyShop","Pieczywo");
        Supplier supplier3 = new Supplier("GlutenFreeShop","Makaron");
        Supplier supplier4 = new Supplier("BioVegetables","Pomidory");

        supplierDatabase.addSupplier(supplier1);
        supplierDatabase.addSupplier(supplier2);
        supplierDatabase.addSupplier(supplier3);
        supplierDatabase.addSupplier(supplier4);


        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderServiceProcessor orderServiceProcessor = new OrderServiceProcessor(new MailService(), new OrderService(), new OrderDatabase());
        orderServiceProcessor.process(orderRequest);
    }
}
