package foodtodoor;

public class Supplier {

    private String companyName;
    private String productName;

    public Supplier(String companyName, String productName) {
        this.companyName = companyName;
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getProductName() {
        return productName;
    }

}
