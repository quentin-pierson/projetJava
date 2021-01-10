package Models.Room;

import java.util.ArrayList;

public class RoomBoss extends Room{
    public RoomBoss(String name, String description, ArrayList<Room> roomNeighbours, boolean isLocked, boolean playerPresent) {
        super(name, description, roomNeighbours, isLocked, playerPresent);
    }
}
