package Models.Room;

import java.util.ArrayList;

public class RoomTransition extends Room{
    public RoomTransition(String name, String description,int order, boolean isLocked, RoomType roomType) {
        super(name, description,order, isLocked, roomType);
    }
}
