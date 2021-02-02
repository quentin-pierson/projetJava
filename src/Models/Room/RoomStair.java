package Models.Room;

import Models.Player;
import Services.Game;

public class RoomStair extends Room{
    public RoomStair(int order, boolean isLocked) {
        super(order, isLocked);
        setName("Room Stair");
        setDescription("/Data/Room/RoomStairData.txt");
    }

    @Override
    public void enterInRoom(Game game){
        game.addStageCross();
    }

}
