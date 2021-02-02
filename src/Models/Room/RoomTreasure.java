package Models.Room;

import Models.Player;
import Services.Game;

public class RoomTreasure extends Room{

    private int gold;

    public RoomTreasure(int order, boolean isLocked, int gold) {
        super(order, isLocked);
        this.gold = gold;
        setName("Room Treasure");
        setDescription("/Data/Room/RoomTreasureData.txt");
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
