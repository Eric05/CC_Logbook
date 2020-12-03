package school.SchoolModels;

public class Room {
    private int floor;
    private int roomNumber;

    public Room(int floor, int room) {
        this.floor = floor;
        this.roomNumber = room;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "floor=" + floor +
                ", room=" + roomNumber +
                '}';
    }
}
