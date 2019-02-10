package foodtodoor;

public class OrderService {
    public boolean order (final Customer customer, final Supplier supplier){
        System.out.println("Order from: " + supplier.getCompanyName() + " is prepared to sent. Thank you and we are looking forward to the future");
        return true;
    }
}
