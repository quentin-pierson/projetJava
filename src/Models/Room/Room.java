package Models.Room;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private ArrayList<Room> roomNeighbours;

    private boolean isLocked;
    private boolean playerPresent;

    public Room(String name, String description, ArrayList<Room> roomNeighbours, boolean isLocked, boolean playerPresent) {
        this.name = name;
        this.description = description;
        this.roomNeighbours = roomNeighbours;
        this.isLocked = isLocked;
        this.playerPresent = playerPresent;
    }
}
