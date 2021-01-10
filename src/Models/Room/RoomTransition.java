package Models.Room;

import java.util.ArrayList;

public class RoomTransition extends Room{
    public RoomTransition(String name, String description, ArrayList<Room> roomNeighbours, boolean isLocked, boolean playerPresent) {
        super(name, description, roomNeighbours, isLocked, playerPresent);
    }
}
