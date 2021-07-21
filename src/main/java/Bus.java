import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;

public class Bus extends Thread implements IBas{

    private static final Logger LOGGER = LogManager.getLogger(Bus.class);
    private static Semaphore semaphore = new Semaphore(5);
    private static Route routeBus;

    public Bus(int number, Route route) {

        super("Bus № " + number);
        routeBus = route;
    }

    @Override
    public void run() {
        leftOnTheRoute();
        returnedToTheDepot();
    }

    @Override
    public void leftOnTheRoute() {
        LOGGER.info(this + " went on the route");
        for (int i = 0; i < routeBus.busStops.length ; i++) {
            try {
                semaphore.acquire();
                pulledUpToBusStop( routeBus.busStops[i]);
                disembarkationEmbarkationOfPassengers();
                leftTheBus(routeBus.busStops[i]);
            } catch (Exception e){
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }
    }

    @Override
    public void pulledUpToBusStop(String busStop) {
        LOGGER.info(this + " drove up to the " + busStop + " bus stop " );
    }

    @Override
    public void disembarkationEmbarkationOfPassengers() {
        Utility.sleep(3000);
    }

    @Override
    public void leftTheBus(String busStop) {

        LOGGER.info(this + " left the stop " + busStop);
    }

    @Override
    public void returnedToTheDepot() {
        LOGGER.info(this + " returned to the depot");
    }

    @Override
    public String toString() { return  this.getName(); }

}
