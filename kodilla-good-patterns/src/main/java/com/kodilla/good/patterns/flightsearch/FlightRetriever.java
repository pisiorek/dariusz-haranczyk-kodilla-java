package com.kodilla.good.patterns.flightsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*public final class FlightRetriever {

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
}*/

public final class FlightRetriever {

    private Map<Integer, Flight> flights = new HashMap<Integer, Flight>();
    //private  final List<Flight> flights = new ArrayList<Flight>();

    public FlightRetriever(){

        flights.put(1, new Flight("Warszawa", "Kraków", "001"));
        flights.put(2, new Flight("Kraków", "Warszawa", "002"));

        flights.put(3, new Flight("Warszawa", "Gdańsk", "003"));
        flights.put(4, new Flight("Gdańsk", "Warszawa", "004"));


    }

    public Map<Integer, Flight> getFlights() {
        return new HashMap<>(flights);
    }
}

