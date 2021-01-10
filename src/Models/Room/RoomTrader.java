package Models.Room;

import java.util.ArrayList;

public class RoomTrader extends Room{
    public RoomTrader(String name, String description, ArrayList<Room> roomNeighbours, boolean isLocked, boolean playerPresent) {
        super(name, description, roomNeighbours, isLocked, playerPresent);
    }
}
