package Services;


import Models.Character.Character;
import Models.ClassType;
import Models.DifficultyType;
import Models.Items.Item;
import Models.Items.PotionHealth;
import Models.Player;
import Models.Room.*;
import Models.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Player player;
    private ArrayList<Stage> stagesNivel = new ArrayList<Stage>();

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

        Character character = new Character(100,10,1,99,10,10,0,12,name,classType);
        PotionHealth potionHealth = new PotionHealth("potion health","healt 100 pv",100);
        player = new Player(name,0,100,3,character);
        player.addItem(potionHealth);
        character.setDeadListener(player);
        generateStage();

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
            if(!isTrap){
                do{
                    System.out.println("+--------------------------+\n" +
                            "|Your choice:              |\n" +
                            "|1: Attack          2: Bag |\n" +
                            "+--------------------------+");
                    System.out.println("Tell me your choice : ");
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
                isTrap = true;
            }
            else{
                monster.fight(player.getCharacter());
                choice=0;
                isTrap = false;
            }
        }while (monster.getHealth() > 0);
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
        int choice = 0;

        for(Item item : player.getInventory()){
            System.out.println(item.getName()+"->"+item.getDescription());
        }

        System.out.println("Choose your item : ");
        System.out.println("0 to skip");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        do{
            if(choice>0 && player.getInventorySize()>=choice){
                player.getInventory().get(choice-1).used(player.getCharacter());
                choice=0;
            }
        }while (choice !=0);


    }

    public void playerSwitchingRoom(){
        int choice=0;
        int i=0;
        do{
            for (Room room : stagesNivel.get(i).getRooms()) {
                System.out.println(room.getName()+" "+room.getDescription());
                switch (room.getRoomType()){
                    case roomBoss:
                        RoomBoss roomBoss = (RoomBoss) room;
                        displayFight(false,roomBoss.getCharacter());
                        System.out.println("YOU HAVE WIN");
                        System.exit(0);
                        break;
                    case roomEnigma:
                        break;
                    case roomFight:
                        RoomFight roomFight = (RoomFight) room;
                        displayFight(false,roomFight.getCharacter());
                        break;
                    case roomStair:
                        i++;
                        break;
                    case roomTrader:
                        RoomTrader roomTrader = (RoomTrader) room;
                        //roomTrader.getTrader();
                        //player.(roomTrader.getTrader().);
                        break;
                    case roomTransition:
                        break;
                    case roomTrap:
                        RoomTrap roomTrap = (RoomTrap) room;
                        displayFight(true,roomTrap.getCharacter());
                        break;
                    case roomTreasure:
                        RoomTreasure roomTreasure = (RoomTreasure) room;
                        System.out.println("You get " + roomTreasure.getGold() + "gold");
                        player.addGold(roomTreasure.getGold());
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
        }while(i != stagesNivel.size());
    }

    public void generateStage(){
        for(int i=1;i<6;i++){
            Stage stage = new Stage(3,10,i);
            stagesNivel.add(stage);
        }
    }
}
