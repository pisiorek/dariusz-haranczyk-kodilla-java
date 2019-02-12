package com.kodilla.good.patterns.flightsearch;

import java.util.HashMap;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;
    private String number;

    public Flight( String arrivalAirport, String departureAirport, String number) {

        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.number = number;
    }


    public String getDepartureAirport() {
        return departureAirport;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String  getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!departureAirport.equals(flight.departureAirport)) return false;
        if (!arrivalAirport.equals(flight.arrivalAirport)) return false;
        return number.equals(flight.number);
    }

    @Override
    public int hashCode() {
        int result = departureAirport.hashCode();
        result = 31 * result + arrivalAirport.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }
}
