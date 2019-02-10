package foodtodoor;

public class OrderRequest {
    private Customer customer;
    private Supplier orderedProduct;
    private int productQuantity;

    public OrderRequest(Customer customer, Supplier orderedProduct, int productQuantity) {
        this.customer = customer;
        this.orderedProduct = orderedProduct;
        this.productQuantity = productQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Supplier getOrderedProduct() {
        return orderedProduct;
    }

    public int getProductQuantity() {
        return productQuantity;
    }
}

