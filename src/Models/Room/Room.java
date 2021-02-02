package Models.Room;

import Models.Player;
import Services.Game;

public class Room {
    protected String name;
    protected String description;
    protected int order;
    protected boolean isLocked;
    protected boolean playerPresent;
    public Room(String name, String description, int order, boolean isLocked) {
        this.name = name;
        this.description = description;
        this.order = order;
        this.isLocked = isLocked;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void enterInRoom(Game game){

    }
}
