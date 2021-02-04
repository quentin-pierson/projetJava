package Models.Room;

import Models.Player;
import Services.DataServices;
import Services.Game;
import View.GameUI;

public class RoomTransition extends Room{
    public RoomTransition(int order, boolean isLocked) {
        super(order, isLocked);
        setName("Room Transition");
        setDescription(DataServices.getInstance().getRoomTransition());
    }

    @Override
    public void enterInRoom(){
        Game game = Game.getInstance();
        String desc = name + ": &&&n" + description;
        GameUI.getInstance().displayGame(desc,game.getPlayer().getCharacter().getSpellName());
    }
}
