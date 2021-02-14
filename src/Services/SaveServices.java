package Services;


import Models.Player;

import java.io.File;
import java.io.FileWriter;

public class SaveServices {
    private static SaveServices instance;

    public static SaveServices getInstance(){
        if(SaveServices.instance == null){
            SaveServices.instance = new SaveServices();
        }
        return instance;
    }

    private Player player;

   /*
    private String nameFile;
    private String descriptionFile;

    public SaveServices(String nameFile, String descriptionFile) {
        this.nameFile = nameFile;
        this.descriptionFile = descriptionFile;

    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    */

    public SaveServices(){}


    //function to create file
    public void createFileSave(){
        try{
            File fileParty = new File("src\\Data\\SaveFile\\"+Game.getInstance().getName()+".txt");
            if(fileParty.createNewFile()){
                System.out.println("Good job"+fileParty.getName());
            }else{
                System.out.println("File alredady exists");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void writeFileSave(){
        try{
            FileWriter filePartyWrite = new FileWriter("src\\Data\\SaveFile\\"+Game.getInstance().getName()+".txt");
            filePartyWrite.write(Game.getInstance().getGameInfo());
            filePartyWrite.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
