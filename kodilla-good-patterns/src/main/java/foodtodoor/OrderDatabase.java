package foodtodoor;

public class OrderDatabase implements OrderRepository{
    @Override
    public boolean createOrder(Customer customer, Supplier supplier) {
        System.out.println("Order has been added to database");
        return false;
    }
}
