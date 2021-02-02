package Models.Room;
import Models.Player;
import Models.Trader;
import Services.Game;

public class RoomTrader extends Room{

    private Trader trader;

    public RoomTrader(int order, boolean isLocked, Trader trader) {
        super(order, isLocked);
        this.trader = trader;
        setName("Room Trader");
        setDescription("/Data/Room/RoomTraderData.txt");
    }

    @Override
    public void enterInRoom(Game game){
        trader.displayInventory(game);
    }
}
