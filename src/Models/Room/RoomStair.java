package Models.Room;

import Models.Player;
import Services.DataServices;
import Services.FileServices;
import Services.Game;
import View.GameUI;

public class RoomStair extends Room{
    public RoomStair(int order, boolean isLocked) {
        super(order, isLocked);
        setName("Room Stair");
        setDescription(DataServices.getInstance().getRoomStair());
    }

    @Override
    public void enterInRoom(){
        Game game = Game.getInstance();
        String desc = name + ": &&&n" + description;
        desc += "YOU CHANGE FLOORS &&&n"+ "YOU ARE IN floor "+game.getStageCross()+"/"+game.getStageSize()+ " &&&n";
        GameUI.getInstance().displayGame(desc,game.getPlayer().getCharacter().getSpellName());
        game.addStageCross();
    }

}
