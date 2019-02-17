package foodtodoor;

public class OrderRequestRetriever {

    public OrderRequest retrieve(){

        Customer customer = new Customer("Ewa", "Kot", "Adres 1");
        Supplier supplier = new Supplier("ExtraFoodShop", "Nabiał");
        int productQuantity = 5;

        return new OrderRequest(customer, supplier , productQuantity);
    }
}
