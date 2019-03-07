package notflight;

public class FlightFinder {

    public static  void main(String []args){
        FlightFinderProcessor flightFinderProcessor = new FlightFinderProcessor();
        Flight find1 = new Flight("KTW");
        try {
            flightFinderProcessor.findFlight(find1);

        } catch (RouteNotFoundException e){
            System.out.println("There is no flights");
        }
    }
}
