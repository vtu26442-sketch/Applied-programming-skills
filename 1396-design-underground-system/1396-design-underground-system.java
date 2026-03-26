import java.util.*;

class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkInMap;
    Map<String, Pair<Integer, Integer>> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        String startStation = checkIn.getKey();
        int startTime = checkIn.getValue();

        int travelTime = t - startTime;
        String routeKey = startStation + "-" + stationName;

        Pair<Integer, Integer> route = routeMap.getOrDefault(routeKey, new Pair<>(0, 0));

        int totalTime = route.getKey() + travelTime;
        int count = route.getValue() + 1;

        routeMap.put(routeKey, new Pair<>(totalTime, count));
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "-" + endStation;
        Pair<Integer, Integer> route = routeMap.get(routeKey);

        return (double) route.getKey() / route.getValue();
    }
}