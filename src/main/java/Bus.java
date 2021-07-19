import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Bus extends Thread implements IBas,IRoute{

    private static final Logger LOGGER = LogManager.getLogger(Bus.class);

    public Bus(int number) {
        super("Bus № " + number);
    }

    @Override
    public void run() {
        LeftOnTheRoute();
        FollowingOnRoute();
        returnedToTheDepot();
    }

    @Override
    public void LeftOnTheRoute() {
        LOGGER.info(this + " the bus went on the route");
    }

    @Override
    public void disembarkationEmbarkationOfPassengers() {
        Utility.sleep(3000);
    }

    @Override
    public void leftTheBus() {
        LOGGER.info(this + " left the stop");
    }

    @Override
    public void returnedToTheDepot() {
        LOGGER.info(this + " returned to the depot");
    }

    @Override
    public String toString() { return  this.getName(); }

    @Override
    public void FollowingOnRoute() {
        int countBusStops = Utility.random(1,6);
        for (int i = 1; i <=countBusStops ; i++) {
            putBusStopsToRoute();
            disembarkationEmbarkationOfPassengers();
            leftTheBus();
        }
    }

    @Override
    public void putBusStopsToRoute() {
        int goodNumber = Utility.random(0, BusStop.busesLength()-1);
        String busStop = BusStop.getBusStop(goodNumber);
        LOGGER.info(this + " " + "arrived at the stop" + " " + busStop);
    }
}
