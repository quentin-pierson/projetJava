package Models.Room;

import java.util.ArrayList;

public class RoomFight extends Room {
    public RoomFight(String name, String description, ArrayList<Room> roomNeighbours, boolean isLocked, boolean playerPresent) {
        super(name, description, roomNeighbours, isLocked, playerPresent);
    }
}
