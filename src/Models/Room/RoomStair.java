package Models.Room;

import Models.Player;
import Services.DataServices;
import Services.FileServices;
import Services.Game;

public class RoomStair extends Room{
    public RoomStair(int order, boolean isLocked) {
        super(order, isLocked);
        setName("Room Stair");
        setDescription(DataServices.getInstance().getRoomStair());
    }

    @Override
    public void enterInRoom(){
        Game game = Game.getInstance();
        game.addStageCross();
    }

}
