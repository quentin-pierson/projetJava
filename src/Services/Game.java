package Services;


import Models.Character.Character;
import Models.Character.CharacterArcher;
import Models.Character.CharacterWarrior;
import Models.Character.CharacterWizard;
import Models.Items.Item;
import Models.Items.PotionHealth;
import Models.Player;
import Models.Room.*;
import Models.Stage;
import View.GameUI;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Game instance;

    public static Game getInstance(){
        if(Game.instance == null){
            Game.instance = new Game();
        }
        return instance;
    }

    private String name;
    private Player player;
    private ArrayList<Stage> stagesNivel = new ArrayList<Stage>();

    private int stageCross;
    private int stageSize;
    private int difficulty = 1;

    public void addStageCross(){
        stageCross+=1;
    }

    public int getStageCross() {
        return stageCross;
    }

    public int getStageSize() {
        return stageSize;
    }

    public Player getPlayer(){
        return player;
    }

    public String getGameInfo(){
        return "Name: "+ player.getName()+"   Type class: "+player.getCharacter().getTypeOfClass()
                + "   Number life: "+player.getLife() + "   Gold: " + player.getGold();
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getName(){
        return name;
    }

    public Player createPlayer(){
        Scanner myObj = new Scanner(System.in);
        int classTypeInt;

        // Enter username and press Enter
        GameUI.getInstance().displayName();
        name = myObj.nextLine();

        int exit = 0;
        Character character = new Character();

        do {
            exit = 1;
            GameUI.getInstance().displayClass();
            classTypeInt = myObj.nextInt();

            switch (classTypeInt) {
                case 1:
                    character = new CharacterWarrior(name);
                    break;
                case 2:
                    character = new CharacterArcher(name);
                    break;
                case 3:
                    character = new CharacterWizard(name);
                    break;
                default:
                    exit = 0;
                    break;
            }
        }while(exit == 0);

        int life = 4-difficulty;

        PotionHealth potionHealth = new PotionHealth("potion health","health 100 pv",100);
        player = new Player(name,0,100, life,character);
        player.addItem(potionHealth);
        character.setDeadListener(player);
        generateStage();

        return player;
    }

    public int setDifficulty() {
        Scanner myObj = new Scanner(System.in);
        int difficultyname;

        int exit = 0;
        do {
            exit = 1;

            //affichage
            GameUI.getInstance().displayDifficulty();

            difficultyname = myObj.nextInt();

            switch (difficultyname) {
                case 1:
                    difficulty = 1; //eazy
                    break;
                case 2:
                    difficulty = 2; // medium
                    break;
                case 3:
                    difficulty = 3; // Hard
                    break;
                case 4:
                    difficulty = 4; // hardocre
                    break;
                default:
                    exit = 0;
                    break;
            }
        }while(exit == 0);

        return difficulty;

    }

    public Character createMonster(){
        int improveDifficulty = 1+(difficulty/10);

        int heath = 100*improveDifficulty;
        int armor = 50*improveDifficulty;
        int level = 1;
        int rateAttack = 50*improveDifficulty;
        int damage = 50*improveDifficulty;
        int lucky = 50*improveDifficulty;
        int mana = 100;
        int dodge = 50*improveDifficulty;

        String name = DataServices.getInstance().getNameMonster();

        Character monsterCreation = new Character(heath,armor,level,rateAttack,damage,lucky,mana,dodge,name);
        return monsterCreation;
    }

    public Character createBoss(){
       int improveDifficulty = 1+(difficulty/5);

       int heath = 100*improveDifficulty;
       int armor = 10*improveDifficulty;
       int level = 1;
       int rateAttack = 50*improveDifficulty;
       int damage = 50*improveDifficulty;
       int lucky = 50*improveDifficulty;
       int mana = 100;
       int dodge = 50*improveDifficulty;

       String name = DataServices.getInstance().getNameBoss();

       Character monsterCreation = new Character(heath,armor,level,rateAttack,damage,lucky,mana,dodge,name);
       return monsterCreation;
    }

    public void displayFight(boolean isTrap,Character monster){
        int choice;
        do{
            if(!isTrap){
                do{
                    GameUI.getInstance().displayGame("",player.getCharacter().getSpellName());
                    Scanner scanner = new Scanner(System.in);
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1: // Attack 1
                            player.getCharacter().fight(monster);
                            choice=3;
                            break;
                        case 2: // Attack 1
                            player.getCharacter().fight(monster);
                            choice=3;
                        case 3: // Attack 1
                            player.getCharacter().fight(monster);
                            choice=3;
                        case 4: // Bag
                            inventory();
                            break;
                        default:

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

        do{
            for (Room room : stagesNivel.get(stageCross).getRooms()) {
                room.enterInRoom();
                do{
                    Scanner scanner = new Scanner(System.in);
                    choice = scanner.nextInt();
                    switch (choice){
                        case 0:
                            break;
                        default:
                            System.out.println("error");
                            break;
                    }
                }while (choice!=0);
            }
        }while(stageCross != stagesNivel.size());
    }

    public void generateStage(){
        for(int i=1;i<6;i++){
            Stage stage = new Stage(3,10,i);
            stagesNivel.add(stage);
        }
        stageSize = stagesNivel.size()-1;
    }

    public void win(){
        System.exit(0);
    }

}
