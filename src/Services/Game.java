package Services;


import Models.Character.Character;
import Models.ClassType;
import Models.DifficultyType;
import Models.Items.Item;
import Models.Player;
import Models.Room.Room;
import Models.Room.RoomFight;
import Models.Room.RoomTrap;
import Models.Stage;

import java.util.Scanner;

public class Game {

    private Player player;
    private Stage stage;

    private String title = "\n" +
            "   ___                                           _____                       __           \n" +
            "  / _ \\ __ __  ___   ___ _ ___  ___   ___       / ___/  ____ ___ _ _    __  / / ___   ____\n" +
            " / // // // / / _ \\ / _ `// -_)/ _ \\ / _ \\     / /__   / __// _ `/| |/|/ / / / / -_) / __/\n" +
            "/____/ \\_,_/ /_//_/ \\_, / \\__/ \\___//_//_/     \\___/  /_/   \\_,_/ |__,__/ /_/  \\__/ /_/   \n" +
            "                   /___/                                                                  \n";

    public String getTitle(){
        return title;
    }

    public Player createPlayer(){
        Scanner myObj = new Scanner(System.in);
        String name;
        int classTypeInt;
        ClassType classType = ClassType.Warrior;
        // Enter username and press Enter
        System.out.println("Enter your game name:");
        name = myObj.nextLine();

        System.out.println("Hello "+name+" nice to meet you. I'm Idony Miracle your playmaker and you will help in the quest of your grale"+"\n");

        int exit = 0;
        do {
            exit = 1;
            System.out.println("Choose your class:\n-1: Warrior\n-2: Archer\n-3: Wizard\n");
            classTypeInt = myObj.nextInt();

            switch (classTypeInt) {
                case 1:
                    classType = ClassType.Warrior;
                    break;
                case 2:
                    classType = ClassType.Archer;
                    break;
                case 3:
                    classType = ClassType.Wizard;
                    break;
                default:
                    exit = 0;
                    break;
            }
        }while(exit == 0);

        Character character = new Character(100,10,1,10,10,10,0,12,name,classType);
        player = new Player(name,0,100,3,character);
        character.setDeadListener(player);
        stage = new Stage(3,10);

        System.out.println("Name: "+ player.getName()+" | "+"Type class: "+player.getCharacter().getClassType()+"\n");
        return player;

    }

    public DifficultyType chooseDifficulty() {
        Scanner myObj = new Scanner(System.in);
        int difficultyname;
        DifficultyType difficultyType = DifficultyType.Easy;

        int exit = 0;
        do {
            exit = 1;
            System.out.println("Choose your difficulty:\n-1: Easy\n-2: Medium\n-3: Hard\n-4: Hardcore\n");
            difficultyname = myObj.nextInt();

            switch (difficultyname) {
                case 1:
                    difficultyType  = DifficultyType.Easy;
                    break;
                case 2:
                    difficultyType  = DifficultyType.Medium;
                    break;
                case 3:
                    difficultyType  = DifficultyType.Hard;
                    break;
                case 4:
                    difficultyType  = DifficultyType.Hardcore;
                    break;
                default:
                    exit = 0;
                    break;
            }
        }while(exit == 0);

        System.out.println("Difficulty chosen: "+difficultyType);
        return difficultyType;

    }

    public void displayFight(boolean isTrap,Character monster){
        int choice;
        do{
            if(isTrap){
                do{
                    System.out.println("+--------------------------+\n" +
                            "|Your choice:              |\n" +
                            "|1: Attack          2: Bag |\n" +
                            "+--------------------------+");
                    Scanner scanner = new Scanner(System.in);
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1: // Attack
                            player.getCharacter().fight(monster);
                            clearScreen();
                            choice=3;
                            break;
                        case 2: // Bag
                            inventory();
                            break;
                        default:
                            System.out.println(("Wrong Choice. Enter again\n"));
                            break;
                    }
                }while (choice!=3);
                isTrap = false;
            }
            else{
                monster.fight(player.getCharacter());
                choice=0;
                isTrap = true;
            }
        }while (monster.getHealth() !=0);
    }


    public void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception E)
        {
            System.out.println(E);
        }
    }

    public void inventory(){
        for(Item item : player.getInventory()){
            System.out.println(item);
        }
    }

    public void playerSwitchingRoom(){
        int choice=0;
        System.out.println("DEBUG : ");
        for (Room room : stage.getRooms()) {
            System.out.println(room.getName()+" "+room.getDescription());
            switch (room.getRoomType()){
                case roomBoss:
                    break;
                case roomEnigma:
                    break;
                case roomFight:
                    RoomFight roomFight = (RoomFight) room;
                    displayFight(false,roomFight.getCharacter());
                    break;
                case roomStair:
                    break;
                case roomTrader:
                    break;
                case roomTransition:
                    break;
                case roomTrap:
                    RoomTrap roomTrap = (RoomTrap) room;
                    displayFight(false,roomTrap.getCharacter());
                    break;
                case roomTreasure:
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            do{
                System.out.println("Press 1 for change room");
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
            }while (choice!=1);
        }
    }
}
