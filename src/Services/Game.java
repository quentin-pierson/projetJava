package Services;

import Models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

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

        Player player = new Player(100,10,1,10,10,10,0,12,name,0,classType,100,1);

        System.out.println("Name: "+ player.getName()+" | "+"Type class: "+player.getClassType()+"\n");
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
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
