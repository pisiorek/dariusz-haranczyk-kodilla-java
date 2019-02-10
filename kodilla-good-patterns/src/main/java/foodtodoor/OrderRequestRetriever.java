package foodtodoor;

public class OrderRequestRetriever {

    public OrderRequest retrieve(){

        Customer customer = new Customer("Ewa", "Kot", "Adres 1");
        Supplier supplier = new Supplier("ExtraFoodShop", "Nabiał", 5);

        return new OrderRequest(customer, supplier);
    }
}
