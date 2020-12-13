package Models;

import java.util.ArrayList;

public class Rooms {
    private String name;
    private RoomType roomType;
    private String description;
    private ArrayList<Rooms> roomNeighbours;

    private boolean isLocked;
    private boolean playerPresent;

    public Rooms(String name, RoomType roomType, String description, ArrayList<Rooms> roomNeighbours, boolean isLocked, boolean playerPresent) {
        this.name = name;
        this.roomType = roomType;
        this.description = description;
        this.roomNeighbours = roomNeighbours;
        this.isLocked = isLocked;
        this.playerPresent = playerPresent;
    }
}
