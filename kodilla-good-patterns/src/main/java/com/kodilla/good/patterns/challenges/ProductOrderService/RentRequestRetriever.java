package com.kodilla.good.patterns.challenges.ProductOrderService;

import java.time.LocalDateTime;

public class RentRequestRetriever {

    public RentRequest retrieve(){

        User user = new User("Ewa", "Kot");

        LocalDateTime rentFrom = LocalDateTime.of(2019,2,9,12,00);
        LocalDateTime rentTo = LocalDateTime.of(2019,5,9,12,00);

        return new RentRequest(user, rentFrom, rentTo);
    }
}
