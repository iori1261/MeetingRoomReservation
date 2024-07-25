package model;

public class MeetingRoom {
    private String roomId;
    private String roomName;
    private int capacity;
    private boolean isReserved;
    private String reserverName;
    private String imagePath;

    public MeetingRoom(String roomId, String roomName, int capacity, String imagePath) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.isReserved = false;
        this.reserverName = "";
        this.imagePath = imagePath;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public String getReserverName() {
        return reserverName;
    }

    public void setReserverName(String reserverName) {
        this.reserverName = reserverName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
