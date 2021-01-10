import Models.*;
import Services.CSVServices;
import Services.FileServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        //Test
        FileServices f = new FileServices();
        String data = f.fileOpen("/Data/WeaponData.txt");

        CSVServices csv = new CSVServices();
        ArrayList<Weapon> wrp = csv.csvParse(data, Weapon.class);

        for (Weapon w: wrp){
            System.out.println(w.toString());
        }

        DifficultyType difficultyType = chooseDifficulty();
        System.out.println("Difficultée:" + difficultyType);

        clearScreen();

        Player player = createPlayer();
        System.out.println("Nom: "+ player.getName() + "\nClasse: " + player.getClassType());

        Monster skeleton = new Monster(300,50,10,50,0,0,0, MonsterType.Skeleton,ClassType.Healer);
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

    private static Player createPlayer(){
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

        Player player = new Player(100,10,1,10,10,0,12,name,0,classType,100,1);

        return player;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
