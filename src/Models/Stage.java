package Models;

import Models.Character.Character;
import Models.Room.*;
import Models.Trader;

import java.util.ArrayList;
import java.util.Random;

public class Stage {
    private int difficulty;
    private int numberRoom;
    private ArrayList<Room> rooms;
    private Stage nextStage;
    private int typeOfRoomGeneration;
    private int orderStage;

    public Stage(int minRoom, int maxRoom) {
        rooms = new ArrayList<Room>();
        generateRoom(minRoom, maxRoom);
        attributRoom();
    }

    private void generateRoom(int minRoom, int maxRoom){
        Random randomRoom = new Random();

        numberRoom = randomRoom.nextInt(maxRoom - minRoom) + minRoom;
        System.out.println(numberRoom);
    }

    public int getOrderStage() {
        return orderStage;
    }

    private void attributRoom(){
        RoomTransition startRoom = new RoomTransition("Start room", "Empty room, it has no interest..", 1, false,RoomType.roomTransition);
        rooms.add(startRoom);
        int previousValue = -1;
        for (int i = 1; i < numberRoom; i++) {
            Random randomRoomType = new Random();

            do {
                typeOfRoomGeneration = randomRoomType.nextInt(100);
            } while (typeOfRoomGeneration == previousValue);
            previousValue = typeOfRoomGeneration;

            if (typeOfRoomGeneration <= 5){
                // Room Treasure
                RoomTreasure roomTreasure = new RoomTreasure("Room Treasure", "A room with a chest in its center", i, false,100,RoomType.roomTreasure);
                rooms.add(roomTreasure);

            } else if ((typeOfRoomGeneration > 5)&&(typeOfRoomGeneration <= 15)){
                // Room Trader
                Trader trader = new Trader();
                RoomTrader roomTrader = new RoomTrader("Room Trader", "A room with a trader in its center", i, false, trader,RoomType.roomTrader);
                rooms.add(roomTrader);

            } else if ((typeOfRoomGeneration > 15)&&(typeOfRoomGeneration <= 25)){
                // Room Trap
                Character monster = new Character(100,0,1,100,100,0,0,0,"zeubis", ClassType.Healer);
                RoomTrap roomTrap = new RoomTrap("Room Trap", "Ouch, you get trap..", i, false, monster,RoomType.roomTrap);
                rooms.add(roomTrap);

            } else if ((typeOfRoomGeneration > 25)&&(typeOfRoomGeneration <= 35)){
                // Room Enigma
                RoomEnigma roomEnigma = new RoomEnigma("Room Enigma", "Hum, there are symbols on the walls of this room", i, false,RoomType.roomEnigma);
                rooms.add(roomEnigma);

            } else if ((typeOfRoomGeneration > 35)&&(typeOfRoomGeneration <= 65)){
                // Room Transition
                RoomTransition roomTransition = new RoomTransition("Room Transition", "Hum, there are symbols on the walls of this room", i, false, RoomType.roomTransition);
                rooms.add(roomTransition);

            } else if ((typeOfRoomGeneration > 65)&&(typeOfRoomGeneration <= 100)){
                // Room Fight
                Character monster = new Character(100,0,1,100,20,0,0,0,"zeubis", ClassType.Healer);
                RoomFight roomFight = new RoomFight("Room Fight", "Oups, there are a lot of enemies in this room.", i, false, monster, RoomType.roomFight);
                rooms.add(roomFight);

            } else {
                System.out.println("Probabilty of room failed");
            }
        }
        if (orderStage % 5 == 0){
            Character monster = new Character(100,0,1,30,50,0,0,0,"Giant Orc", ClassType.Healer);
            RoomBoss roomBoss = new RoomBoss("Boss room", "OUH ! There is a giant monster comming your way, prepare yourself..", numberRoom, false,monster,RoomType.roomBoss);
            rooms.add(roomBoss);
        } else {
            RoomStair roomStair = new RoomStair("Room stair", "Empty room, it has a stairs..", numberRoom, false,RoomType.roomStair);
            rooms.add(roomStair);
        }

    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}


