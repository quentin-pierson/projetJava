package Models.Room;

import java.util.ArrayList;

public class RoomTreasure extends Room{

    private int gold;

    public RoomTreasure(String name, String description, int order, boolean isLocked, int gold) {
        super(name, description, order, isLocked);
        this.gold = gold;
    }

    public int getGold(){
        return gold;
    }
}
