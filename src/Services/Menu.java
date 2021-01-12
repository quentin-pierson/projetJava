package Services;

import Models.ClassType;
import Models.MonsterType;

import java.util.Scanner;


public class Menu {


    public void menu(){
        Game game = new Game();
        System.out.println(game.getTitle());
        int choice;
        do {
            System.out.println("--------Menu-------- \n"+
                    "1: Play \n"+
                    "2: Settings\n"+
                    "3. Exit \n"+
                    "Choosing your choice :"
            );

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Play
                    game.createPlayer();
                    game.clearScreen();
                    game.chooseDifficulty();
                    choice=3;
                    break;
                case 2:
                    // Change settings
                    System.out.println("Settings");
                    choice=3;
                    break;
                case 3:
                    // Exit games
                    System.out.println("You quit the game i hope to see you soon");
                    break;
                default:
                    // The user input an unexpected choice.
                    System.out.println(("Wrong Choice. Enter again\n"));
                    break;
            }
        }while (choice!=3);
    }

    public void fight(){
        int choice;
        Monster monster = new Monster(100,0,1,10,20,0,0,0,"zeubis", MonsterType.Skeleton, ClassType.Healer);
        do{
            System.out.println("+--------------------------+\n" +
                    "|Your choice:              |\n" +
                    "|1: Attack          2: Bag |\n" +
                    "+--------------------------+");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Attack
                    break;
                case 2: // Bag
                    break;
            }
        }while (monster.getHealth() !=0);
    }
}
