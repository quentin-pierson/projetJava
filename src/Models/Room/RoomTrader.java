package Models.Room;
import Models.Player;
import Models.Trader;
import Services.Game;

public class RoomTrader extends Room{

    private Trader trader;

    public RoomTrader(String name, String description, int order, boolean isLocked, Trader trader) {
        super(name, description, order, isLocked);
        this.trader = trader;
    }

    public Trader getTrader(){
        return trader;
    }

    @Override
    public void enterInRoom(Game game){

    }
}
