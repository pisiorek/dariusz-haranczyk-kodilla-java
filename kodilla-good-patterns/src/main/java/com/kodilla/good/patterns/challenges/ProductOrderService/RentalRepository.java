package com.kodilla.good.patterns.challenges.ProductOrderService;

import java.time.LocalDateTime;

public interface RentalRepository {
    boolean createRental(User user, LocalDateTime rentFrom, LocalDateTime rentTo);
}
