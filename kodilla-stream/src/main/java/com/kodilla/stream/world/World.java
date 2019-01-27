package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World implements QuantityPeopleOfTheWorld {

    private  final List<Continent> listOfContinents;

    public  World(){
        listOfContinents= new ArrayList<>();
    }

    @Override
    public BigDecimal getPeopleQuantity(){
        return listOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountriesOnContinent().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public List<Continent> getListOfContinents(){
        return listOfContinents;
    }
}
