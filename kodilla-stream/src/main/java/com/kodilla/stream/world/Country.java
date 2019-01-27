package com.kodilla.stream.world;

import java.math.BigDecimal;


public final class Country implements QuantityPeopleOfTheWorld {

    private final String countryName;
    private final BigDecimal peopleQuantity;

    public Country(final String countryName, final BigDecimal peopleQuantity){
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }
    @Override
    public BigDecimal getPeopleQuantity(){
        //BigDecimal peopleQuantity = new BigDecimal("98765432101234567890");
        return peopleQuantity;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", peopleQuantity=" + peopleQuantity +
                '}';
    }
}
