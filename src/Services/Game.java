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
        return "Name: "+ player.getName()+"   Type class: "+player.getCharacter().getTypeOfClass() +"   Health: "+player.getCharacter().getHealth()
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
        char classTypeInt;

        do{
            // Enter username and press Enter
            GameUI.getInstance().displayName();
            name = myObj.nextLine();
        }while(name.length()>10);


        int exit = 0;
        Character character = new Character();

        do {
            exit = 1;
            GameUI.getInstance().displayClass();
            classTypeInt = myObj.next().charAt(0);

            switch (classTypeInt) {
                case '1':
                    character = new CharacterWarrior(name);
                    break;
                case '2':
                    character = new CharacterArcher(name);
                    break;
                case '3':
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
        char difficultyname;

        int exit = 0;
        do {
            exit = 1;

            //affichage
            GameUI.getInstance().displayDifficulty();

            difficultyname = myObj.next().charAt(0);

            switch (difficultyname) {
                case '1':
                    difficulty = 1; //eazy
                    break;
                case '2':
                    difficulty = 2; // medium
                    break;
                case '3':
                    difficulty = 3; // Hard
                    break;
                case '4':
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
        int armor = 10*improveDifficulty;
        int level = 1;
        int rateAttack = 20*improveDifficulty;
        int damage = 5*improveDifficulty;
        int lucky = 10*improveDifficulty;
        int mana = 100;
        int dodge = 20*improveDifficulty;

        String name = DataServices.getInstance().getNameMonster();

        CharacterWarrior monsterCreation = new CharacterWarrior(heath,armor,level,rateAttack,damage,lucky,mana,dodge,name);
        return monsterCreation;
    }

    public Character createBoss(){
       int improveDifficulty = 1+(difficulty/5);

       int heath = 100*improveDifficulty;
       int armor = 15*improveDifficulty;
       int level = 1;
       int rateAttack = 30*improveDifficulty;
       int damage = 10*improveDifficulty;
       int lucky = 5*improveDifficulty;
       int mana = 100;
       int dodge = 2*improveDifficulty;

       String name = DataServices.getInstance().getNameBoss();

       CharacterWarrior monsterCreation = new CharacterWarrior(heath,armor,level,rateAttack,damage,lucky,mana,dodge,name);
       return monsterCreation;
    }

    public void displayFight(boolean isTrap,Character monster,String desc){
        char choice;
        Scanner scanner = new Scanner(System.in);
        String description = "";
        do{
            if(!isTrap){
                description = desc + "&&&n";
                do{
                    GameUI.getInstance().displayGame(desc,player.getCharacter().getSpellName());
                    choice = scanner.next().charAt(0);
                    switch (choice) {
                        case '1': // Attack 1
                            description += player.getCharacter().fight(monster);
                            choice='3';
                            break;
                        case '2': // Attack 1
                            description += player.getCharacter().fight(monster);
                            choice='3';
                            break;
                        case '3': // Attack 1
                            description += player.getCharacter().fight(monster);
                            choice='3';
                            break;
                        case '4': // Bag
                            inventory();
                            break;
                        default:

                            break;
                    }
                }while (choice!='3');
                GameUI.getInstance().displayGame(description,player.getMenuText());
                scanner.next().charAt(0);
                isTrap = true;
            }
            else{
                if(!monster.isDead()){
                    description = desc + "&&&n"+ monster.fight(player.getCharacter());
                    choice=0;
                    isTrap = false;
                    GameUI.getInstance().displayGame(description,player.getMenuText());

                    scanner.next().charAt(0);
                }
            }
        }while (!monster.isDead());
        description = desc + "&&&n"+ monster.getName() + " is dead";
        GameUI.getInstance().displayGame(description,player.getMenuText());
        scanner.next().charAt(0);
    }

    public void inventory(){
        char choice = '0';

        for(Item item : player.getInventory()){
            System.out.println(item.getName()+"->"+item.getDescription());
        }

        System.out.println("Choose your item : ");
        System.out.println("0 to skip");

        do{
            Scanner scanner = new Scanner(System.in);
            choice = scanner.next().charAt(0);
            try {
                int castChoicetoInt = (int) choice;
                if(castChoicetoInt> 0 && player.getInventorySize()>=castChoicetoInt){
                    player.getInventory().get(castChoicetoInt-1).used(player.getCharacter());
                    choice='0';
                }
            }catch (Exception e){
            }

        }while (choice !='0');
    }

    public void playerSwitchingRoom(){
        char choice='0';

        do{
            for (Room room : stagesNivel.get(stageCross).getRooms()) {
                room.enterInRoom();
                Scanner scanner = new Scanner(System.in);
                scanner.next();
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
