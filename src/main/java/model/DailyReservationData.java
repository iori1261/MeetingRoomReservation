package model;

import java.util.HashMap;
import java.util.Map;

public class DailyReservationData {
    private Map<String, MeetingRoom> rooms = new HashMap<>();

    public DailyReservationData() {
        rooms.put("A", new MeetingRoom("A", "会議室A", 10, "images/kaigi1.jpg"));
        rooms.put("B", new MeetingRoom("B", "会議室B", 10, "images/kaigi2.jpg"));
        rooms.put("C", new MeetingRoom("C", "会議室C", 10, "images/kaigi3.jpg"));
        rooms.put("D", new MeetingRoom("D", "会議室D", 10, "images/kaigi4.jpg"));
    }

    public Map<String, MeetingRoom> getRooms() {
        return rooms;
    }
}
