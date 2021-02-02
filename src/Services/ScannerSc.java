package Services;

import java.util.Scanner;

public class ScannerSc {

    public int scanner(){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        return choice;
    }
}
