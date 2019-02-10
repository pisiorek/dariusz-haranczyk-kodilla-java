package foodtodoor;

public class Supplier {

    private String companyName;
    private String productName;
    private int quantity;

    public Supplier(String companyName, String productName, int quantity) {
        this.companyName = companyName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}
