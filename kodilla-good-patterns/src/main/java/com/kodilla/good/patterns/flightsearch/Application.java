package com.kodilla.good.patterns.flightsearch;

public class Application {
    public static void main(String []args){

        FlightRetriever flightRetriever = new FlightRetriever();
        SearchFlightService searchFlightService = new SearchFlightService("Poznań", "Szczecin", flightRetriever);
        searchFlightService.searchFlight();
    }
}
