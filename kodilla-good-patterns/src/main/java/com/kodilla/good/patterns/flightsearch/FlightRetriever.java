package com.kodilla.good.patterns.flightsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FlightRetriever {

    //private  final Map<Integer, Flight> flights = new HashMap<Integer, Flight>();
    private  final List<Flight> flights = new ArrayList<Flight>();
        public FlightRetriever(){
            flights.add(new Flight("Warszawa", "Kraków", "001"));
            flights.add(new Flight("Warszawa", "Katowice", "002"));
            flights.add(new Flight("Warszawa", "Gdańsk", "003"));
            flights.add(new Flight("Poznań", "Kraków", "004"));
            flights.add(new Flight("Poznań", "Katowice","005"));
            flights.add(new Flight("Wrocław", "Kraków","006"));
            flights.add(new Flight("Kraków", "Bydgoszcz","007"));
            flights.add(new Flight("Poznań", "Bydgoszcz","008"));
            flights.add(new Flight("Wrocław", "Szczecin","009"));
            flights.add(new Flight("Warszawa", "Bydgoszcz","010"));
            flights.add(new Flight("Bydgoszcz", "Rzeszów","011"));

        }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }
}
