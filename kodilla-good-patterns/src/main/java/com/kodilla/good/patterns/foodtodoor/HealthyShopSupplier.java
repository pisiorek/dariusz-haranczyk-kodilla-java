package com.kodilla.good.patterns.foodtodoor;

public class HealthyShopSupplier implements Supplier{

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;
    private String productName;
    private String companyName;

    public HealthyShopSupplier(InformationService informationService, OrderService orderService,
                               OrderRepository orderRepository, String productName, String companyName) {

        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.productName = productName;
        this.companyName = companyName;
    }
    @Override
    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getCustomer(), orderRequest.getSupplier(), orderRequest.getProductQuantity());

        if (isOrdered) {
            informationService.inform(orderRequest.getCustomer());
            orderRepository.createOrder(orderRequest);
            System.out.println("Wiadomość wysłana z metody process HealthyShopSupplier");
            return new OrderDto(orderRequest.getCustomer(), true);
        } else {
            return new OrderDto(orderRequest.getCustomer(), false);
        }
    }
    @Override
    public String getProductName(){
        return productName;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

}
