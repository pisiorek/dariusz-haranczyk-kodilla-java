package foodtodoor;

public class Application {
    public static  void main(String []args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderServiceProcessor orderServiceProcessor = new OrderServiceProcessor(new MailService(), new OrderService(), new OrderDatabase());
        orderServiceProcessor.process(orderRequest);
    }
}
