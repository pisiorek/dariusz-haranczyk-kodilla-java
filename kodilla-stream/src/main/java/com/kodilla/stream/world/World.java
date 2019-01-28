package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World implements QuantityPeopleOfTheWorld {

    //lista przechowuje listę kontynentów - deklaracja
    private  final List<Continent> continents;

    public  World(){
        //inicjalizacja listy w konstruktorze
        continents= new ArrayList<>();
    }

    @Override
    public BigDecimal getPeopleQuantity(){
        return continents.stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public List<Continent> getListOfContinents(){
        return continents;
    }
}
