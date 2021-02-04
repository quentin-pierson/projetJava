package Models.Room;

import Models.Player;
import Services.DataServices;
import Services.Game;
import View.GameUI;

public class RoomTreasure extends Room{

    private int gold;

    public RoomTreasure(int order, boolean isLocked, int gold) {
        super(order, isLocked);
        this.gold = gold;
        setName("Room Treasure");
        setDescription(DataServices.getInstance().getRoomTreasure());
    }

    public int getGold(){
        return gold;
    }

    @Override
    public void enterInRoom(){
        Game game = Game.getInstance();
        description += "&&&nYou get " + getGold() + "gold";
        GameUI.getInstance().displayGame(getDescriptionAndName(),game.getPlayer().getMenuText());
        game.getPlayer().addGold(getGold());
    }

}
