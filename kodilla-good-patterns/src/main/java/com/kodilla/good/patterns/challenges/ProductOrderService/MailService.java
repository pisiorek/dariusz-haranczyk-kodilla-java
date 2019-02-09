package com.kodilla.good.patterns.challenges.ProductOrderService;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Send information to user");
    }
}
