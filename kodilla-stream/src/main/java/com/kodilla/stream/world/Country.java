package com.kodilla.stream.world;

import java.math.BigDecimal;


public final class Country implements QuantityPeopleOfTheWorld {

    private  String name;
    private BigDecimal peopleQuantity;

    public Country(final String countryName, final BigDecimal peopleQuantity){
        this.name = countryName;
        this.peopleQuantity = peopleQuantity;
    }
    @Override
    public BigDecimal getPeopleQuantity(){

        return peopleQuantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + name + '\'' +
                ", peopleQuantity=" + peopleQuantity +
                '}';
    }
}
