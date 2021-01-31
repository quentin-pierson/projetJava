package Models.Room;

public class Room {
    protected String name;
    protected String description;
    protected int order;
    protected boolean isLocked;
    protected boolean playerPresent;
    protected RoomExisting roomExisting;
    public Room(String name, String description, int order, boolean isLocked, RoomExisting roomExisting) {
        this.name = name;
        this.description = description;
        this.order = order;
        this.isLocked = isLocked;
        this.roomExisting = roomExisting;
    }
    public RoomExisting getRoomExisting(){
        return roomExisting;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
