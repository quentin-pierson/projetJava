package Models.Room;

import Models.Player;
import Services.Game;

public class RoomTransition extends Room{
    public RoomTransition(String name, String description,int order, boolean isLocked) {
        super(name, description,order, isLocked);
    }

    @Override
    public void enterInRoom(Game game){

    }
}
