package Services;

import java.util.Scanner;

public class ScannerSc {

    private static ScannerSc instance;

    public static ScannerSc getInstance(){
        if(ScannerSc.instance == null){
            ScannerSc.instance = new ScannerSc();
        }
        return instance;
    }

    public char scanner(){
        char choice = '0';
        Scanner scanner = new Scanner(System.in);
        choice = scanner.next().charAt(0);
        return choice;
    }
}
