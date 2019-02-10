package foodtodoor;

public interface OrderRepository {
    boolean createOrder(Customer customer, Supplier supplier);
}
