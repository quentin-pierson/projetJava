import Models.*;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        DifficultyType difficultyType = chooseDifficulty();
        System.out.println("Difficultée:" + difficultyType);

        clearScreen();

        Players player = createPlayer();
        System.out.println("Nom: "+ player.getName() + "\nClasse: " + player.getClassType());

        Monsters skeleton = new Monsters(300,50,10,50,0,0,0, MonsterType.Skeleton,ClassType.Healer);
        System.out.println(skeleton.toString());
    }

    public static DifficultyType chooseDifficulty() {
        Scanner myObj = new Scanner(System.in);
        int difficultyname;
        DifficultyType difficultyType = DifficultyType.Easy;

        int exit = 0;
        do {
            exit = 1;
            System.out.println("Choisissez votre difficulté:\n-1: Facile\n-2: Normal\n-3: Difficile\n-4: Extrème\n");
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

        return difficultyType;

    }

    private static Players createPlayer(){
        Scanner myObj = new Scanner(System.in);
        String name;
        int classTypeInt;
        ClassType classType = ClassType.Warrior;
        // Enter username and press Enter
        System.out.println("Entrer votre nom:");
        name = myObj.nextLine();

        int exit = 0;
        do {
            exit = 1;
            System.out.println("Choisissez votre classe:\n-1: Guerrier\n-2: Archer\n-3: Mage\n");
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

        Players player = new Players(100,10,1,10,10,0,12,name,0,classType,100,1);

        return player;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
