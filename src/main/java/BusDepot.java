import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BusDepot {
    public static void main(String[] args) {
        List<Bus> buses = new ArrayList<>(100);

        final Logger LOGGER = LogManager.getLogger(BusDepot.class);

        new BusStop();

        LOGGER.info("----------------------------The day has begun-----------------------------");
        Route route = new Route();//составлен маршрут движения

        LOGGER.info(route.toString());
        int number = 0;
        for (int time = 0; time <=50 ; time++) {
            // каждую секунду выезжает от 0 до 2 автобусов
            int count = Utility.random(0,2);
            for (int i = 1; i <= count; i++) {
                Bus bus = new Bus(++number, route);
                buses.add(bus);
                bus.start();
            }
        }
        for (Bus bus : buses) {
            try {
                bus.join();
            } catch (InterruptedException e) {
                LOGGER.error("YPS !!!");
            }
        }
        LOGGER.info("----------------------------The day has finish-----------------------------");
    }

}
