package foodToDoor;

public class OrderServiceProcessorS1 implements OrderProcess{

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderServiceProcessorS1(InformationService informationService, OrderService orderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto process( final OrderRequest orderRequest){
        boolean isOrdered = orderService.order(orderRequest.getCustomer(), orderRequest.getSupplier(), orderRequest.getProductQuantity());

        if (isOrdered) {
            informationService.inform(orderRequest.getCustomer());
            orderRepository.createOrder(orderRequest);
            System.out.println("Wiadomość wysłana z metody process SUPLIER_1");
            return new OrderDto(orderRequest.getCustomer(), true);
        } else {
            return new OrderDto(orderRequest.getCustomer(), false);
        }
    }
}

