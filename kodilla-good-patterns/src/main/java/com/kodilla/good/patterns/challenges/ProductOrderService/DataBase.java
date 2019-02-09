package com.kodilla.good.patterns.challenges.ProductOrderService;

import java.time.LocalDateTime;

public class DataBase implements RentalRepository {

    @Override
    public boolean createRental(User user, LocalDateTime rentFrom, LocalDateTime rentTo) {
        return true;
    }
}
