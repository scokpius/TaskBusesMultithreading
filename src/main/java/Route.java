import java.util.Arrays;

public class Route implements IRoute{
    String busStops[] ;
    public Route(){

        createRoute();
    }

    @Override
    public void createRoute() {
        int countBusStops = Utility.random(3,6);
        busStops = new String[countBusStops];
        for (int i = 0; i <=countBusStops-1 ; i++) {
            for (int j = 0; j < busStops.length; j++) {
                if (busStops[j] != putBusStopsToRoute())
                    busStops[i] = putBusStopsToRoute();
            }
        }
    }

    @Override
    public String putBusStopsToRoute() {
        int busStopNumber = Utility.random(0, BusStop.busesLength()-1);
        String busStop = BusStop.getBusStop(busStopNumber);

        return  busStop;
    }

    @Override
    public String toString() {
        return "Route {" +
                "busStops " + Arrays.toString(busStops) +
                '}';
    }
}
