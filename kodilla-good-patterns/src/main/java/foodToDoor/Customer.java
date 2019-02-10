package foodToDoor;

public class Customer {
    private String name;
    private String surname;
    private String deliveryAddress;

    public Customer(String name, String surname, String deliveryAddress) {
        this.name = name;
        this.surname = surname;
        this.deliveryAddress = deliveryAddress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
