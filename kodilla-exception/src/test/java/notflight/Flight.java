package notflight;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;

    public Flight(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}
