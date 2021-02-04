package Models.Room;
import Models.Player;
import Models.Trader;
import Services.DataServices;
import Services.Game;
import View.GameUI;

public class RoomTrader extends Room{

    private Trader trader;

    public RoomTrader(int order, boolean isLocked, Trader trader) {
        super(order, isLocked);
        this.trader = trader;
        setName("Room Trader");
        setDescription(DataServices.getInstance().getRoomTrader());
    }

    @Override
    public void enterInRoom(){
        Game game = Game.getInstance();
        String desc = name + ": &&&n" + description;
        trader.displayInventory(desc);
    }
}
