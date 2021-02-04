package Services;

import View.GameUI;

import java.util.Scanner;


public class Menu {


    public void menu(){
        Game game = Game.getInstance();

        char choice;
        do {
            GameUI.getInstance().displayMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    // Play
                    game.setDifficulty();
                    game.createPlayer();
                    game.playerSwitchingRoom();
                    choice=3;
                    break;
                case '2':
                    // Change settings
                    System.out.println("Settings");
                    choice=3;
                    break;
                case '3':
                    // Exit games
                    System.out.println("You quit the game i hope to see you soon");
                    break;
                default:
                    // The user input an unexpected choice.
                    break;
            }
        }while (choice!='3');
    }
}
