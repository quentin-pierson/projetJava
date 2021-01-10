import Models.ClassType;
import Models.Monster;
import Models.MonsterType;
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
        DifficultyType difficultyType = chooseDifficulty();
        System.out.println("Difficultée:" + difficultyType);

        clearScreen();

        Player player = createPlayer();
        System.out.println("Nom: "+ player.getName() + "\nClasse: " + player.getClassType());

         */

        Monster skeleton = new Monster(300,50,10,50,0,0,0, MonsterType.Skeleton, ClassType.Healer);
        System.out.println(skeleton.toString());
    }

}
