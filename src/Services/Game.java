package Services;

import Models.*;
import Models.Character.Character;
import Models.Player;

import java.util.Scanner;

public class Game {
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
        Player player = new Player(name,0,100,3,character);

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

    public void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception E)
        {
            System.out.println(E);
        }
    }
}
