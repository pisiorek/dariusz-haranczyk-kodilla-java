package com.kodilla.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public class Database implements RentalRepository {

    @Override
    public boolean createRental(User user, LocalDateTime rentFrom, LocalDateTime rentTo) {
        return true;
    }
}
