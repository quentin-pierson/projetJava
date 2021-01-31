package Models.Room;

public class RoomTransition extends Room{
    public RoomTransition(String name, String description,int order, boolean isLocked, RoomExisting roomExisting) {
        super(name, description,order, isLocked, roomExisting);
    }
}
