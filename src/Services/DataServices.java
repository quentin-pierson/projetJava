package Services;

import Models.Armors.ArmorCloth;
import Models.Armors.ArmorIron;
import Models.Armors.ArmorLeather;
import Models.Armors.ArmorPlate;
import Models.Weapons.WeaponBow;
import Models.Weapons.WeaponScepter;
import Models.Weapons.WeaponSword;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class DataServices {

    private static DataServices instance;

    public static DataServices getInstance() {
        if (DataServices.instance == null) {
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

    private ArrayList<WeaponSword> listWeaponSword;
    private ArrayList<WeaponScepter> listWeaponScepter;
    private ArrayList<WeaponBow> listWeaponBow;

    private ArrayList<ArmorCloth> listArmorCloth;
    private ArrayList<ArmorIron> listArmorIron;
    private ArrayList<ArmorLeather> listArmorLeather;
    private ArrayList<ArmorPlate> listArmorPlate;


    public DataServices() {
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

        // Weapons
        listWeaponSword = CSVServices.getInstance().csvParse("/Data/Weapon/WeaponSword.txt", WeaponSword.class);
        listWeaponScepter = CSVServices.getInstance().csvParse("/Data/Weapon/WeaponScepter.txt", WeaponScepter.class);
        listWeaponBow = CSVServices.getInstance().csvParse("/Data/Weapon/WeaponBow.txt", WeaponBow.class);

        listArmorCloth = CSVServices.getInstance().csvParse("/Data/Armor/ArmorCloth.txt", ArmorCloth.class);
        listArmorIron = CSVServices.getInstance().csvParse("/Data/Armor/ArmorIron.txt", ArmorIron.class);
        listArmorLeather = CSVServices.getInstance().csvParse("/Data/Armor/ArmorLeather.txt", ArmorLeather.class);
        listArmorPlate = CSVServices.getInstance().csvParse("/Data/Armor/ArmorPlate.txt", ArmorPlate.class);


    }

    private int randome(int size) {
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

    public WeaponBow getWeaponBow(int i) {
        return listWeaponBow.get(i);
    }

    public WeaponScepter getWeaponScepter(int i) {
        return listWeaponScepter.get(i);
    }

    public WeaponSword getWeaponSword(int i) {
        return listWeaponSword.get(i);
    }

    public ArmorIron getArmorIron(int i) {
        return listArmorIron.get(i);
    }

    public ArmorPlate getArmorPlate(int i) {
        return listArmorPlate.get(i);
    }

    public ArmorLeather getArmorLeather(int i) {
        return listArmorLeather.get(i);
    }

    public ArmorCloth getArmorCloth(int i) {
        return listArmorCloth.get(i);
    }

}
