package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final List<Country> countries;

    public Continent(){
        this.countries = new ArrayList<>();
    }

    public List<Country> getListOfCountries(){
        return countries;
    }
    @Override
    public String toString() {
        return "Continent{" +
                "listOfCountriesOnContinent=" + countries +
                '}';
    }

}
