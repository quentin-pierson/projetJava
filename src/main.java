import Models.*;
import Services.CSVServices;
import Services.FileServices;
import Services.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.menu();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
