package Models.Room;

public class RoomTreasure extends Room{

    private int gold;

    public RoomTreasure(String name, String description, int order, boolean isLocked, int gold, RoomExisting roomExisting) {
        super(name, description, order, isLocked, roomExisting);
        this.gold = gold;
    }

    public int getGold(){
        return gold;
    }
}
