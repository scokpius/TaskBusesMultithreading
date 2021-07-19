import java.util.*;

public class BusStop {
    private static Map<String, Integer> busStops = new HashMap<>();
    private static Set<Map.Entry<String, Integer>> entries = busStops.entrySet();
    private static List<String> list = new ArrayList<String>(entries.size());

    public BusStop() {

        busStops.put("Independence Square", 1);
        busStops.put("Yakub Kolas Square", 1);
        busStops.put("Krasnozvezdnaya street", 1);
        busStops.put("Botanical Garden", 1);
        busStops.put("Kamarovsky market", 1);
        busStops.put("cinema Mir", 1);
        busStops.put("winners square", 1);
        busStops.put("Gikalo street", 1);
        busStops.put("Gikalo street", 1);
        busStops.put("Gorky Park", 1);
        for (Map.Entry<String, Integer> entry : entries) {
            list.add(entry.getKey()+ " " + entry.getValue());
        }
    }
    static int busesLength(){
        return busStops.size();
    }

    static String getBusStop(int number) {
        return  list.get(number); //entries.toArray().toString();
    }

}
