package notflight;

import java.util.HashMap;
import java.util.Map;

public class FlightFinderProcessor {
    private Map<String, Boolean> listOfAirPorts= new HashMap<>();
    private boolean trueOrFalse;

    public FlightFinderProcessor() {

        listOfAirPorts.put("KTW", true);
        listOfAirPorts.put("DTM", true);
        listOfAirPorts.put("BGD", true);
        listOfAirPorts.put("AGT", true);
        listOfAirPorts.put("MRK", false);
        listOfAirPorts.put("ADR", false);
        listOfAirPorts.put("WRC", false);
        listOfAirPorts.put("QWE", false);
        listOfAirPorts.put("ZZZ", false);
    }

    public void  findFlight(Flight flight) throws RouteNotFoundException {

        for(Map.Entry<String,Boolean> entry : listOfAirPorts.entrySet()){
            if (entry.getKey().equals(flight.getArrivalAirport()) && entry.getValue()){
                trueOrFalse = true;
            }
        }

        if(trueOrFalse) {
            for(Map.Entry<String,Boolean> entry : listOfAirPorts.entrySet()){
                if(entry.getKey() == flight.getArrivalAirport()){
                    //listOfAirPorts.put(entry.getKey(),entry.getValue());
                    System.out.println("Yes, the flight exist");
                }
               }
            //System.out.println("Znalezione połączenia to "+ listOfAirPorts.get(flight));
           //return  listOfExistFlights;

        }else{
            throw new RouteNotFoundException("There is no flights");
        }
    }

}
