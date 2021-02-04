package Services;


import Models.Character.Character;
import Models.Character.CharacterArcher;
import Models.Character.CharacterWarrior;
import Models.Character.CharacterWizard;
import Models.ChooseDifficulty;
import Models.Items.Item;
import Models.Items.PotionHealth;
import Models.Player;
import Models.Room.*;
import Models.Stage;
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

    private Player player;
    private ArrayList<Stage> stagesNivel = new ArrayList<Stage>();
    private int stageCross;
    private int stageSize;
    private int difficulty = 1;



    private String title = "\n" +
            "   ___                                           _____                       __           \n" +
            "  / _ \\ __ __  ___   ___ _ ___  ___   ___       / ___/  ____ ___ _ _    __  / / ___   ____\n" +
            " / // // // / / _ \\ / _ `// -_)/ _ \\ / _ \\     / /__   / __// _ `/| |/|/ / / / / -_) / __/\n" +
            "/____/ \\_,_/ /_//_/ \\_, / \\__/ \\___//_//_/     \\___/  /_/   \\_,_/ |__,__/ /_/  \\__/ /_/   \n" +
            "                   /___/                                                                  \n";

    public String getTitle(){
        return title;
    }

    public void addStageCross(){
        stageCross+=1;
        System.out.println("YOU CHANGE FLOORS \n"+ "YOU ARE IN floor "+stageCross+"/"+stageSize+ " \n");

    }

    public Player getPlayer(){
        return player;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Player createPlayer(){
        Scanner myObj = new Scanner(System.in);
        String name;
        int classTypeInt;
        // Enter username and press Enter
        System.out.println("Enter your game name:");
        name = myObj.nextLine();

        System.out.println("Hello "+name+" nice to meet you. I'm Idony Miracle your playmaker and I will help you to find the holy graal"+"\n");

        int exit = 0;
        Character character = new Character();

        do {
            exit = 1;
            System.out.println("Choose your class:\n-1: Warrior\n-2: Archer\n-3: Wizard\n");
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

        System.out.println("Name: "+ player.getName()+" | "+"Type class: "+player.getCharacter().getTypeOfClass()+"\n"+ "Number life "+player.getLife());
        return player;
    }

    public int setDifficulty() {
        Scanner myObj = new Scanner(System.in);
        int difficultyname;

        int exit = 0;
        do {
            exit = 1;
            System.out.println("Choose your difficulty:\n-1: Easy\n-2: Medium\n-3: Hard\n-4: Hardcore\n");
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

        System.out.println("Difficulty chosen: "+ difficulty);
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

        do{
            for (Room room : stagesNivel.get(stageCross).getRooms()) {
                System.out.println(room.getName()+" "+room.getDescription());
                room.enterInRoom();
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
                clearScreen();
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
        System.out.println("      _.+._\n" +
                "     (^\\/^\\/^)\n" +
                "      \\@*@*@/\n" +
                "      {_____}");
        System.out.println("\n" +
                "            /¯¯ \\\u0091                  /¯¯¯\\ '                    /\\ '                                             /\\'\u0082                              /\\\u0082                    /\\\u0082             \n" +
                "           |\\      \\'               /         \\\u0082                 /    \\     '                                     /    \\               /\\'\u0082         /    \\\u0082                /    \\ \u0082          \n" +
                "           |:|      |             /            '\\°              |\\      \\\u0082                                       |\\      \\'           /    \\      /      /|              /        \\\u0091         \n" +
                "           |/      /|\u0091           |        |\\      \\°            |:|      |    /'\\\u0082                                |:|      |          |\\      \\°  |      |:'|             |\\          \\        \n" +
                "          /      /::| /¯¯¯'/|  |        |::\\      \\ '\u0082         |/      /|  /    \\                               |/      /|          |:|      '|  |      |:'|           /\\|::\\         '\\  '    \n" +
                "         |      |:::/      /::|  |\\       '\\:::\\      \\ '       /      /::| |\\      \\                            /      /::|          |/      /|  |\\      \\/         /    \\:::\\         \\\u0082    \n" +
                "         |\\      \\/      /::::|\u0091 |::\\       '\\::|      |      /      /::::| |:|      '|                         /      /::::|         /      /::|\u0091 |::\\      \\      /        \\:::\\        '\\ ° \n" +
                "         |::\\___/|    |::::/\u0091  |::::\\       '\\|      |    /      /:::::/  |/      /|                       /      /:::::/        /      /::::|' |:::|      |'    |\\          \\::|         |'  \n" +
                "   /¯¯¯¯¯\\:::|/    /|::/      \\:::::\\            /|  /      /:::::/'  /      /::|'\u0082                    /      /:: /¯¯¯|    /      /:::::/ °\\:::|      |°   |:|       |\\  \\/        /|\u0091  \n" +
                " /       /|\\   \\/    /::|/\u0091         \\:::::\\____ /::| |      |:::::/  /      /::::|'\u0082                   |      |:::/   /|  |  /      /:::::/°     \\/      /|    |/       /|::\\____ /::|'  \n" +
                "|       |:'|::\\___/:::'|             \\::::|::::::|:::'| |\\      \\::/_/      (:::::/                     |\\      \\/   /::|  |/      /:::::/       /      /::|   /       /::|:::|::::::|:::|\u0091  \n" +
                "|\\     /|:'|:::|::::|::::/               \\::|::::::|::/\u0091 '|::\\______/|\\    /|::/\u0091                      |::\\____/::::|____ /:::::/\u0091       |\\    /::::|° |\\     /::::|\\::|::::::|::/\u0091   \n" +
                "|::\\ /::|'/ \\::|::::|::/\u0091                  \\|::::::|/\u0091   '|:::|:::::::::|:|::\\/::|/\u0091                        |:::|::::::|::::/|:::::::|::::/'         |::\\/:::::/   |::\\ /:::::/   \\|::::::|/  '   \n" +
                "|:::|:::|    '\\|::::|/                       ¯¯¯'       \\::|:::::::::|:|::|:::|\u0091                          \\::|::::::|::/  |:::::::|::/'\u0082          |:::|::::/ '\u0082  |:::|::::/       ¯¯¯        \n" +
                " \\::|::/       ¯¯                         \u0091              \\|:::::::::|/\\::|::/   °                         \\|::::::|/    |:::::::|/'\u0082             \\::|::/       \\::|::/                      \n" +
                "   \\|/'                                                \u0091     ¯¯¯¯¯    \\|/                                 ¯¯¯       ¯¯¯¯                  \\|/           \\|/                        \n");
        System.exit(0);
    }

}
