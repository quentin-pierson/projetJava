package Models.Room;

import Models.Player;
import Services.Game;

public class RoomStair extends Room{
    public RoomStair(String name, String description, int order, boolean isLocked) {
        super(name, description, order, isLocked);
    }

    @Override
    public void enterInRoom(Game game){
        game.addStageCross();
    }
}
