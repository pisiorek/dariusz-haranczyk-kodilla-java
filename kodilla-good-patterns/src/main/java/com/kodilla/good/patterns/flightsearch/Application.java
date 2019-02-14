package com.kodilla.good.patterns.flightsearch;

import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String []args){

        String startAirport = "Poznań";
        String destinationAirport = "Szczecin";

        FlightRetriever flightRetriever = new FlightRetriever();
        FlightRetriever flightRetriever1 = new FlightRetriever();
        FlightRetriever flightRetriever2 = new FlightRetriever();

        System.out.println("All flights from airport in: " + startAirport);
        Map<String,Flight> resultFlights = flightRetriever.getFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(startAirport))
                .collect(Collectors.toMap(Flight::getNumber, flight -> flight));

        System.out.println("Quantity of flights: " + resultFlights.size());
        resultFlights.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
        System.out.println("\n");

        System.out.println("All flights to airport in: " + destinationAirport);
        Map<String,Flight> resultFlights1 = flightRetriever1.getFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(destinationAirport))
                .collect(Collectors.toMap(Flight::getNumber, flight -> flight));

        System.out.println("Quantity of flights: " + resultFlights1.size());
        resultFlights1.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
        System.out.println("\n");

        Map<String,Flight> resultFlights2 = flightRetriever2.getFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(startAirport) || flight.getArrivalAirport().equals(destinationAirport))
                .collect(Collectors.toMap(Flight::getNumber, flight -> flight));

        System.out.println("Combined flights between " + startAirport + " and " + destinationAirport);
        for(Map.Entry <String,Flight> entry : resultFlights2.entrySet()){

            for(Map.Entry <String,Flight> entry1 : resultFlights2.entrySet()) {

                if (entry.getValue().getArrivalAirport().equals(entry1.getValue().getDepartureAirport())) {
                    System.out.println( entry.getValue().toString() + "\n" + entry1.getValue().toString());
                }
            }
        }
    }
}
