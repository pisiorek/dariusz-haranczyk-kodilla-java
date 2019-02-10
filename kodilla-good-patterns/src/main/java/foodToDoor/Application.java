package foodToDoor;

public class Application {
    public static  void main(String []args) {

        SupplierDatabase supplierDatabase = new SupplierDatabase();
        Supplier supplier1 = new Supplier("ExtraFoodShop","Nabiał", 1000);
        Supplier supplier2 = new Supplier("HealthyShop","Pieczywo", 500);
        Supplier supplier3 = new Supplier("GlutenFreeShop","Makaron", 600);
        Supplier supplier4 = new Supplier("BioVegetables","Pomidory", 200);

        supplierDatabase.addSupplier(supplier1);
        supplierDatabase.addSupplier(supplier2);
        supplierDatabase.addSupplier(supplier3);
        supplierDatabase.addSupplier(supplier4);

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderServiceProcessorS1 orderServiceProcessor = new OrderServiceProcessorS1(new MailService(), new OrderService(), new OrderDatabase());
        orderServiceProcessor.process(orderRequest);
    }
}
