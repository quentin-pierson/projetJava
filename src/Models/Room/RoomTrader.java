package Models.Room;
import Models.Trader;

public class RoomTrader extends Room{

    private Trader trader;

    public RoomTrader(String name, String description, int order, boolean isLocked, Trader trader, RoomExisting roomExisting) {
        super(name, description, order, isLocked, roomExisting);
        this.trader = trader;
    }

    public Trader getTrader(){
        return trader;
    }
}
