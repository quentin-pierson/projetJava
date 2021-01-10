package Models.Room;

import java.util.ArrayList;

public class RoomTreasure extends Room{
    public RoomTreasure(String name, String description, ArrayList<Room> roomNeighbours, boolean isLocked, boolean playerPresent) {
        super(name, description, roomNeighbours, isLocked, playerPresent);
    }
}
