package Services;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class DataServices {

    private static DataServices instance;

    public static DataServices getInstance(){
        if(DataServices.instance == null){
            DataServices.instance = new DataServices();
        }
        return instance;
    }


    private ArrayList<String> nameListMonster;
    private ArrayList<String> nameListBoss;
    private ArrayList<String> roomListBoss;
    private ArrayList<String> roomListEnigma;
    private ArrayList<String> roomListFight;
    private ArrayList<String> roomListStair;
    private ArrayList<String> roomListTrader;
    private ArrayList<String> roomListTransition;
    private ArrayList<String> roomListTrap;
    private ArrayList<String> roomListTreasure;


    public DataServices(){
        nameListMonster = FileServices.getInstance().fileReader("/Data/Enemie/EnemieStage.txt"); // fait

        nameListBoss = FileServices.getInstance().fileReader("/Data/Enemie/EnemieBoss.txt"); // fait

        roomListBoss = FileServices.getInstance().fileReader("/Data/Room/RoomBossData.txt"); // fait

        roomListEnigma = FileServices.getInstance().fileReader("/Data/Room/RoomEnigmaData.txt"); //fait

        roomListFight = FileServices.getInstance().fileReader("/Data/Room/RoomFightData.txt"); //fait

        roomListStair = FileServices.getInstance().fileReader("/Data/Room/RoomStairData.txt"); //fait

        roomListTransition = FileServices.getInstance().fileReader("/Data/Room/RoomTransitionData.txt"); //fait

        roomListTrap = FileServices.getInstance().fileReader("/Data/Room/RoomTrapData.txt"); //fait

        roomListTrader = FileServices.getInstance().fileReader("/Data/Room/RoomTraderData.txt"); // fait

        roomListTreasure = FileServices.getInstance().fileReader("/Data/Room/RoomTreasureData.txt"); // fait

    }

    private int randome(int size){
        Random random = new Random();
        return random.nextInt(size);

    }

    public String getNameMonster() {
        return nameListMonster.get(randome(nameListMonster.size()));
    }


    public String getNameBoss() {
        return nameListBoss.get(randome(nameListBoss.size()));
    }

    public String getRoomEnigma() {
        return roomListEnigma.get(randome(roomListEnigma.size()));
    }

    public String getRoomFight() {
        return roomListFight.get(randome(roomListFight.size()));
    }

    public String getRoomBoss() {
        return roomListBoss.get(randome(roomListBoss.size()));
    }

    public String getRoomStair() {
        return roomListStair.get(randome(roomListStair.size()));
    }

    public String getRoomTrader() {
        return roomListTrader.get(randome(roomListTrader.size()));
    }

    public String getRoomTransition() {
        return roomListTransition.get(randome(roomListTransition.size()));
    }

    public String getRoomTrap() {
        return roomListTrap.get(randome(roomListTrap.size()));
    }

    public String getRoomTreasure() {
        return roomListTreasure.get(randome(roomListTreasure.size()));
    }



}
