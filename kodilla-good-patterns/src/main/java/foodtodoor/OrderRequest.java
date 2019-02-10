package foodtodoor;

public class OrderRequest {
    private Customer customer;
    private Supplier orderedProduct;

    public OrderRequest(Customer customer, Supplier orderedProduct) {
        this.customer = customer;
        this.orderedProduct = orderedProduct;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Supplier getOrderedProduct() {
        return orderedProduct;
    }
}

