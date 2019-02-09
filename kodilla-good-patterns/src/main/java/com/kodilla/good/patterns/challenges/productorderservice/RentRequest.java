package com.kodilla.good.patterns.challenges.productorderservice;

import java.time.LocalDateTime;

public class RentRequest {
    private User user;
    private LocalDateTime rentFrom;
    private LocalDateTime rentTo;

    public RentRequest(User user, LocalDateTime rentFrom, LocalDateTime rentTo) {
        this.user = user;
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getRentFrom() {
        return rentFrom;
    }

    public LocalDateTime getRentTo() {
        return rentTo;
    }
}
