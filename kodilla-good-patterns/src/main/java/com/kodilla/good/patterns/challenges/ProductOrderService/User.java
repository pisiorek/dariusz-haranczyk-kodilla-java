package com.kodilla.good.patterns.challenges.ProductOrderService;

public class User {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public User(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

}
