package notflight;

import java.util.HashMap;
import java.util.Map;

public class FlightFinderProcessor {
    private Map<String, Boolean> listOfAirPorts= new HashMap<>();
    private boolean flightIsAvailable;

    public FlightFinderProcessor() {

        listOfAirPorts.put("KTW", true);
        listOfAirPorts.put("DTM", true);
        listOfAirPorts.put("BGD", true);
        listOfAirPorts.put("AGT", true);
        listOfAirPorts.put("MRK", false);
        listOfAirPorts.put("ADR", false);
        listOfAirPorts.put("WRC", false);
        listOfAirPorts.put("QWE", false);
    }

    public void  findFlight(Flight flight) throws RouteNotFoundException {

        for(Map.Entry<String,Boolean> entry : listOfAirPorts.entrySet()){
            if (entry.getKey().equals(flight.getArrivalAirport()) && entry.getValue()){
                flightIsAvailable = true;
            }
        }

        if(flightIsAvailable) {
            for(Map.Entry<String,Boolean> entry : listOfAirPorts.entrySet()){
                if(entry.getKey().equals(flight.getArrivalAirport())){
                    System.out.println("Yes, the flight exist");
                }
            }
                } else {
                    throw new RouteNotFoundException("There is no flights");
                }
    }
}
