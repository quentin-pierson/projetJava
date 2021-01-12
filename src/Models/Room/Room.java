package Models.Room;

import java.util.ArrayList;

public class Room {
    protected String name;
    protected String description;
    protected int order;
    protected boolean isLocked;
    protected boolean playerPresent;
    protected RoomType roomType;
    public Room(String name, String description, int order, boolean isLocked, RoomType roomType) {
        this.name = name;
        this.description = description;
        this.order = order;
        this.isLocked = isLocked;
        this.roomType = roomType;
    }
    public RoomType getRoomType(){
        return roomType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
