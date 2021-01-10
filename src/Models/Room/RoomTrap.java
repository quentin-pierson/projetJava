package Models.Room;

import java.util.ArrayList;

public class RoomTrap extends Room{
    public RoomTrap(String name, RoomType roomType, String description, ArrayList<Room> roomNeighbours, boolean isLocked, boolean playerPresent) {
        super(name, roomType, description, roomNeighbours, isLocked, playerPresent);
    }
}
