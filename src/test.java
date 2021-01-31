import Models.Character.Character;
import Models.ListClassExisting;
import Models.Weapon;
import Services.CSVServices;
import Services.FileServices;

import java.util.ArrayList;

public class test {

    public void example() {

        //Test
        FileServices f = new FileServices();
        String data = f.fileOpen("/Data/WeaponData.txt");

        CSVServices csv = new CSVServices();
        ArrayList<Weapon> wrp = csv.csvParse(data, Weapon.class);

        for (Weapon w: wrp){
            System.out.println(w.toString());
        }

        /*
        ChooseDifficulty difficultyType = chooseDifficulty();
        System.out.println("Difficultée:" + difficultyType);

        clearScreen();

        Player player = createPlayer();
        System.out.println("Nom: "+ player.getName() + "\nClasse: " + player.getListClassExisting());

         */

        Character skeleton = new Character(300,50,10,50,0,0,0, 0,"Skeleton", ListClassExisting.Healer);
        System.out.println(skeleton.toString());
    }

}
