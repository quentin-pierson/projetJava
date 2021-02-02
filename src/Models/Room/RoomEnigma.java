package Models.Room;

import Models.Player;
import Services.Game;

public class RoomEnigma extends Room{
    public RoomEnigma(String name, String description,int order, boolean isLocked) {
        super(name, description, order, isLocked);
    }
    @Override
    public void enterInRoom(Game game){

    }
}
