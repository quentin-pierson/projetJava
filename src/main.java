import Models.ClassType;
import Models.Players;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Players player = createPlayer();
        System.out.println("Nom: "+ player.getName() + "\nClasse: " + player.getClassType());
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
            System.out.println("Choisissez votre classe:\n-1: Guerrier\n-2: Archer\n-3: Mage");
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

        Players player = new Players(100,10,1,10,10,0,12,name,0,classType);

        return player;
    }
}
