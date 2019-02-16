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

    public void streamProccesor( Map<String, Flight> resultFlights){
        System.out.println("Quantity of flights: " + resultFlights.size());
        resultFlights.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void serchFlight(){
        System.out.println("All flights from airport in: " + startAirport);
    Map<String,Flight> resultFlights = flightRetriever.getFlights().stream()
            .filter(flight -> flight.getDepartureAirport().equals(startAirport))
            .collect(Collectors.toMap(Flight::getNumber, flight -> flight));
    streamProccesor(resultFlights);

        System.out.println("All flights to airport in: " + destinationAirport);
    Map<String,Flight> resultFlights1 = flightRetriever.getFlights().stream()
            .filter(flight -> flight.getArrivalAirport().equals(destinationAirport))
            .collect(Collectors.toMap(Flight::getNumber, flight -> flight));

    streamProccesor(resultFlights1);

    Map<String,Flight> resultFlights2 = flightRetriever.getFlights().stream()
            .filter(flight -> flight.getDepartureAirport().equals(startAirport) || flight.getArrivalAirport().equals(destinationAirport))
            .collect(Collectors.toMap(Flight::getNumber, flight -> flight));

        System.out.println("Combined flights between " + startAirport + " and " + destinationAirport);
        for(Map.Entry <String,Flight> entry : resultFlights2.entrySet()) {

            for (Map.Entry<String, Flight> entry1 : resultFlights2.entrySet()) {

                if (entry.getValue().getArrivalAirport().equals(entry1.getValue().getDepartureAirport())) {
                    System.out.println(entry.getValue().toString() + "\n" + entry1.getValue().toString());
                }
            }
        }
    }
}
