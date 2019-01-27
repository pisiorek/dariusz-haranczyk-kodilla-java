package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final List<Country> listOfCountriesOnContinent;

    public Continent(){
        this.listOfCountriesOnContinent = new ArrayList<>();
    }

    public List<Country> getListOfCountriesOnContinent(){
        return listOfCountriesOnContinent;
    }
    @Override
    public String toString() {
        return "Continent{" +
                "listOfCountriesOnContinent=" + listOfCountriesOnContinent +
                '}';
    }

}
