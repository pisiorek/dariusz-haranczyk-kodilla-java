package com.kodilla.good.patterns.challenges.ProductOrderService;

public class Application {
    public static  void main(String []args) {

        RentRequestRetriever rentRequestRetriever = new RentRequestRetriever();
        RentRequest rentRequest = rentRequestRetriever.retrieve();

        RentalProcessor rentalProcessor = new RentalProcessor(new MailService(), new RentalService(), new DataBase());

        rentalProcessor.process(rentRequest);

    }
}
