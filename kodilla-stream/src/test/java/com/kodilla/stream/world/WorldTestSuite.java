package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class WorldTestSuite {

        @Test
        public void testGetQuantityPeopleOfTheWOrld() {
            //Given
            Continent europe = new Continent();
            Continent asia = new Continent();
            Continent africa = new Continent();
            Continent america = new Continent();
            World world = new World();

            europe.getListOfCountriesOnContinent().add(new Country("Polska", new BigDecimal("40000000")));
            europe.getListOfCountriesOnContinent().add(new Country("Niemcy", new BigDecimal("80000000")));
            europe.getListOfCountriesOnContinent().add(new Country("Chorwacja", new BigDecimal("4000000")));
            europe.getListOfCountriesOnContinent().add(new Country("Francja", new BigDecimal("80000000")));

            asia.getListOfCountriesOnContinent().add(new Country("Chiny", new BigDecimal("1500000000")));
            asia.getListOfCountriesOnContinent().add(new Country("Indie", new BigDecimal("1200000000")));
            asia.getListOfCountriesOnContinent().add(new Country("Mongolia", new BigDecimal("20000000")));
            asia.getListOfCountriesOnContinent().add(new Country("Japonia", new BigDecimal("200000000")));

            africa.getListOfCountriesOnContinent().add(new Country("Maroko", new BigDecimal("3000000")));
            africa.getListOfCountriesOnContinent().add(new Country("Tunezja", new BigDecimal("4000000")));
            africa.getListOfCountriesOnContinent().add(new Country("Egipt", new BigDecimal("10000000")));
            africa.getListOfCountriesOnContinent().add(new Country("Algieria", new BigDecimal("5500000")));

            america.getListOfCountriesOnContinent().add(new Country("USA", new BigDecimal("250000000")));
            america.getListOfCountriesOnContinent().add(new Country("Canada", new BigDecimal("150000000")));
            america.getListOfCountriesOnContinent().add(new Country("USA", new BigDecimal("250000000")));
            america.getListOfCountriesOnContinent().add(new Country("USA", new BigDecimal("250000000")));

            world.getListOfContinents().add(europe);
            world.getListOfContinents().add(africa);
            world.getListOfContinents().add(asia);
            world.getListOfContinents().add(america);

            //When
            BigDecimal totalPeopleOfTheWorld = world.getPeopleQuantity();

            //Then
            BigDecimal expectedQuantityPeople = new BigDecimal("4046500000");
            Assert.assertEquals(expectedQuantityPeople, totalPeopleOfTheWorld);
        }
}
