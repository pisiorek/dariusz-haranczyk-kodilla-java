package com.kodilla.good.patterns.foodtodoor;

public class MailService implements InformationService {
    @Override
    public void inform(Customer customer) {
        System.out.println("Send information to customer by email");
    }
}
