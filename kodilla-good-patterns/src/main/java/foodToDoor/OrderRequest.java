package foodToDoor;

public class OrderRequest {
    private Customer customer;
    private Supplier supplier;
    private int productQuantity;

    public OrderRequest(Customer customer, Supplier supplier, int productQuantity) {
        this.customer = customer;
        this.supplier = supplier;
        this.productQuantity = productQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getProductQuantity() {
        return productQuantity;
    }
}

