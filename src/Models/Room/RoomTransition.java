package Models.Room;

import Models.Player;
import Services.Game;

public class RoomTransition extends Room{
    public RoomTransition(int order, boolean isLocked) {
        super(order, isLocked);
        setName("Room Transition");
        setDescription("/Data/Room/RoomTransitionData.txt");
    }

    @Override
    public void enterInRoom(Game game){

    }
}
