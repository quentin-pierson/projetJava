package Models.Room;

import java.util.ArrayList;

public class RoomEnigma extends Room{
    public RoomEnigma(String name, String description, ArrayList<Room> roomNeighbours, boolean isLocked, boolean playerPresent) {
        super(name, description, roomNeighbours, isLocked, playerPresent);
    }
}
