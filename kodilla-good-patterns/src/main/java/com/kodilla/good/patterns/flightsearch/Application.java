package com.kodilla.good.patterns.flightsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String []args){

        FlightRetriever flightRetriever = new FlightRetriever();
        FlightRetriever flightRetriever1 = new FlightRetriever();

        Map<String,Flight> resultFlights = flightRetriever.getFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals("Warszawa"))
                .collect(Collectors.toMap(Flight::getNumber, flight -> flight));

        System.out.println("Number of flights: " + resultFlights.size());
        resultFlights.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        Map<String,Flight> resultFlights1 = flightRetriever1.getFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals("Bydgoszcz"))
                .collect(Collectors.toMap(Flight::getNumber, flight -> flight));

        System.out.println("Number of flights: " + resultFlights1.size());
        resultFlights1.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

/*        flightRetriever.getFlights().entrySet().stream()
                .filter(flight -> flight.getValue().getArrivalAirport().equals("Kraków"))
                .collect(Collectors.toMap(Flight::getNumber, flight -> flight));*/





    }
}
