package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World implements QuantityPeopleOfTheWorld {

    //lista przechowuje listę kontynentów - deklaracja
    private   List<Continent> continents;

    public  World(){
        //inicjalizacja listy w konstruktorze
        continents= new ArrayList<>();
    }

    @Override
    public BigDecimal getPeopleQuantity(){

        //aby dobrać się do najgłębszych danych w klasie Country o ilości ludnosci
        //w poszczególnych krajach, najpierw musimy stworzyć streama z listy listOfContinents najwyzszej w hierarchii z klasy World
        //w kolejnej linii tworzymy flatMapę,która wchodzi wgłab do kolejnej listy. continent w lambdzie reprezentuje element
        // ze streamu wczesniejszego i na nim wywołujemy
        //getListOfCountriesOnContinents zwracajacy liste z ktorej robimy stream poziomu Country - poziom głębiej niż lista kontynentów-
        //gdy już jestesmy na poziomie Country to możemy wyciągnąć informacje o ilosci ludnosci w poszczególnych państwach
        //operacja terminalna reduce zwraca sumuje ilosc ludnosci i zwraca jej wartość
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

    public List<Continent> getContinents(){
        return continents;
    }
}
