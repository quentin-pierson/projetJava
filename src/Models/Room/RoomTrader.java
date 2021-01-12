package Models.Room;
import Models.Trader;
import java.util.ArrayList;

public class RoomTrader extends Room{

    private Trader trader;

    public RoomTrader(String name, String description, int order, boolean isLocked, Trader trader, RoomType roomType) {
        super(name, description, order, isLocked, roomType);
        this.trader = trader;
    }

    public Trader getTrader(){
        return trader;
    }
}
