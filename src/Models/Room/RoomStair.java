package Models.Room;

import java.util.ArrayList;

public class RoomStair extends Room{
    public RoomStair(String name, String description, ArrayList<Room> roomNeighbours, boolean isLocked, boolean playerPresent) {
        super(name, description, roomNeighbours, isLocked, playerPresent);
    }
}
