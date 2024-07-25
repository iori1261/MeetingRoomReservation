package model;

import java.util.HashMap;
import java.util.Map;

public class ReservationData {
    private Map<String, DailyReservationData> reservations = new HashMap<>();

    public DailyReservationData getDailyReservationData(String date) {
        return reservations.computeIfAbsent(date, k -> new DailyReservationData());
    }
}
