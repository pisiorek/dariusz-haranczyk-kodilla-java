package com.kodilla.good.patterns.flightsearch;

import java.util.Map;
import java.util.stream.Collectors;

public class SearchFlightService {

    private String startAirport;
    private String destinationAirport;
    private FlightRetriever flightRetriever;

    public SearchFlightService(String startAirport, String destinationAirport, FlightRetriever flightRetriever){
        this.startAirport = startAirport;
        this.destinationAirport = destinationAirport;
        this.flightRetriever = flightRetriever;
    }

    private FlightDto streamProccesor(Map<String, Flight> resultFlights){
        System.out.println("Quantity of flights: " + resultFlights.size());
        resultFlights.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
        System.out.println("\n");
        return new FlightDto(resultFlights);
    }

    private Map<String, Flight> showFlightsFromAirport(){
        System.out.println("All flights from airport in: " + startAirport);
        Map<String,Flight> resultFlights = flightRetriever.getFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(startAirport))
                .collect(Collectors.toMap(Flight::getNumber, flight -> flight));
        return  resultFlights;
    }

    private Map<String, Flight> showFlightsToAirport(){
        System.out.println("All flights to airport in: " + destinationAirport);
        Map<String,Flight> resultFlights = flightRetriever.getFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(destinationAirport))
                .collect(Collectors.toMap(Flight::getNumber, flight -> flight));
        return  resultFlights;
    }

    private FlightDto searchCombinedFlight(){
        Map<String,Flight> resultCombinedFlights = flightRetriever.getFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(startAirport) || flight.getArrivalAirport().equals(destinationAirport))
                .collect(Collectors.toMap(Flight::getNumber, flight -> flight));

        System.out.println("Combined flights between " + startAirport + " and " + destinationAirport);
        for(Map.Entry <String,Flight> entry : resultCombinedFlights.entrySet()) {

            for (Map.Entry<String, Flight> entry1 : resultCombinedFlights.entrySet()) {

                if (entry.getValue().getArrivalAirport().equals(entry1.getValue().getDepartureAirport())) {

                    System.out.println(entry.getValue().toString() + "\n" + entry1.getValue().toString());
                }
            }
        }

        return new FlightDto(resultCombinedFlights);
    }

    public void searchFlight(){
        streamProccesor(showFlightsFromAirport());
        streamProccesor(showFlightsToAirport());
        searchCombinedFlight();
    }
}