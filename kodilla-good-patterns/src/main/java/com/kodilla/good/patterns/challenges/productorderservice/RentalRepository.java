package com.kodilla.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public interface RentalRepository {
    boolean createRental(User user, LocalDateTime rentFrom, LocalDateTime rentTo);
}
