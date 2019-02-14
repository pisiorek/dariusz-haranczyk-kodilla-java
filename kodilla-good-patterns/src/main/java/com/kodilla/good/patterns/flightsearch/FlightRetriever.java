package com.kodilla.good.patterns.flightsearch;

import java.util.ArrayList;
import java.util.List;


public final class FlightRetriever {

    private  final List<Flight> flights = new ArrayList<Flight>();
        public FlightRetriever(){
            flights.add(new Flight("Warszawa", "Kraków", "001"));
            flights.add(new Flight("Kraków", "Warszawa", "002"));

            flights.add(new Flight("Warszawa", "Gdańsk", "003"));
            flights.add(new Flight("Gdańsk", "Warszawa", "004"));

            flights.add(new Flight("Poznań", "Katowice","005"));
            flights.add(new Flight("Katowice", "Poznań","006"));

            flights.add(new Flight("Poznań", "Bydgoszcz","007"));
            flights.add(new Flight("Bydgoszcz", "Poznań","008"));

            flights.add(new Flight("Bydgoszcz", "Szczecin","009"));
            flights.add(new Flight("Szczecin", "Bydgoszcz","010"));

        }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }
}
