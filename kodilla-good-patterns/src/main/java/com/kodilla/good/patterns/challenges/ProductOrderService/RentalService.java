package com.kodilla.good.patterns.challenges.ProductOrderService;

import java.time.LocalDateTime;

public class RentalService {

    public boolean rent (final User user, final LocalDateTime rentFrom, final LocalDateTime rentTo){
        System.out.println("Renting for: " + user.getName() + " " + user.getSurname() + " from: " + rentFrom.toString() + " to: " + rentTo.toString());
        return true;
    }
}
