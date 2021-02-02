package Models.Room;

import Models.Player;
import Services.Game;

public class RoomEnigma extends Room{
    public RoomEnigma(int order, boolean isLocked) {
        super(order, isLocked);
        setName("Room Enigma");
        setDescription("/Data/Room/RoomEnigmaData.txt");
    }
    @Override
    public void enterInRoom(Game game){

    }

}
