package Models.Room;

import Models.Player;
import Services.Game;

public class RoomTreasure extends Room{

    private int gold;

    public RoomTreasure(String name, String description, int order, boolean isLocked, int gold) {
        super(name, description, order, isLocked);
        this.gold = gold;
    }

    public int getGold(){
        return gold;
    }

    @Override
    public void enterInRoom(Game game){
        System.out.println("You get " + getGold() + "gold");
        game.getPlayer().addGold(getGold());
    }
}
