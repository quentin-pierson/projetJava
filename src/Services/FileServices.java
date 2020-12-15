package Services;
import java.io.File;
import java.util.Scanner;

public class FileServices {
    public String fileOpen(String filePath) {
        //text file, should be opening in default text editor
        File file = new File(getClass().getResource(filePath).getFile());
        String val = "";

        try{
            if(file.exists()){
                Scanner myReader = new Scanner(file);

                while (myReader.hasNextLine()){
                    val += myReader.nextLine() + "\n";
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return val;
    }
}
