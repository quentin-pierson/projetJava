package Models;

import Models.Character.Character;
import Models.Room.*;

import java.util.ArrayList;
import java.util.Random;

public class Stage {
    private int difficulty;
    private int numberRoom;
    private ArrayList<Room> rooms;
    private Stage nextStage;
    private int typeOfRoomGeneration;
    private int orderStage;

    public Stage(int minRoom, int maxRoom,int orderStage) {
        rooms = new ArrayList<Room>();
        this.orderStage = orderStage;
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
        RoomTransition startRoom = new RoomTransition(1, false);
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
                RoomTreasure roomTreasure = new RoomTreasure(i, false,100);
                rooms.add(roomTreasure);

            } else if ((typeOfRoomGeneration > 5)&&(typeOfRoomGeneration <= 15)){
                // Room Trader
                Trader trader = new Trader();
                RoomTrader roomTrader = new RoomTrader(i, false, trader);
                rooms.add(roomTrader);

            } else if ((typeOfRoomGeneration > 15)&&(typeOfRoomGeneration <= 25)){
                // Room Trap
                Character monster = new Character(1,0,1,100,1,0,0,0,"Skeleton", ListClassExisting.Healer);
                RoomTrap roomTrap = new RoomTrap(i, false, monster);
                rooms.add(roomTrap);

            } else if ((typeOfRoomGeneration > 25)&&(typeOfRoomGeneration <= 35)){
                // Room Enigma
                RoomEnigma roomEnigma = new RoomEnigma(i, false);
                rooms.add(roomEnigma);

            } else if ((typeOfRoomGeneration > 35)&&(typeOfRoomGeneration <= 65)){
                // Room Transition
                RoomTransition roomTransition = new RoomTransition(i, false);
                rooms.add(roomTransition);

            } else if ((typeOfRoomGeneration > 65)&&(typeOfRoomGeneration <= 100)){
                // Room Fight
                Character monster = new Character(1,0,1,100,2,0,0,0,"Skeleton", ListClassExisting.Healer);
                RoomFight roomFight = new RoomFight(i, false, monster);
                rooms.add(roomFight);

            } else {
                System.out.println("Probabilty of room failed");
            }
        }
        if ((orderStage % 5) == 0){
            System.out.println(orderStage);
            Character monster = new Character(20,0,1,30,30,0,0,0,"Giant Orc", ListClassExisting.Healer);
            RoomBoss roomBoss = new RoomBoss(numberRoom, false,monster);
            rooms.add(roomBoss);
        } else {
            RoomStair roomStair = new RoomStair(numberRoom, false);
            rooms.add(roomStair);
        }

    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}


