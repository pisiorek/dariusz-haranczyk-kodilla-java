package foodToDoor;

public interface OrderProcess {

/*      void OrderServiceProcessor(final InformationService informationService,
                                  final OrderService orderService,
                                  final OrderRepository orderRepository);*/

      OrderDto process(final OrderRequest orderRequest);
}
