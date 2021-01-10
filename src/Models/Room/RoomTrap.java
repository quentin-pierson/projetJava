package Models.Room;

import java.util.ArrayList;

public class RoomTrap extends Room{
    public RoomTrap(String name, String description, ArrayList<Room> roomNeighbours, boolean isLocked, boolean playerPresent) {
        super(name, description, roomNeighbours, isLocked, playerPresent);
    }
}
