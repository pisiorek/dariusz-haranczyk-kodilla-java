package com.kodilla.good.patterns.flightsearch;

import java.util.Map;

public class FlightDto {

        public Map<String, Flight> resultFlights;

        public FlightDto(Map<String, Flight> resultFlights) {
            this.resultFlights = resultFlights;
        }

    public Map<String, Flight> getResultFlights() {
        return resultFlights;
    }
}

