package View;

import Services.Game;

import java.util.ArrayList;

public class GameUI {
    private static GameUI instance;

    public static GameUI getInstance(){
        if(GameUI.instance == null){
            GameUI.instance = new GameUI();
        }
        return instance;
    }

    int screenHeight = 25;
    int screenLength = 150;

    private String titleText =
            "   ___                                           _____                       __           &&&n" +
            "  / _ \\ __ __  ___   ___ _ ___  ___   ___       / ___/  ____ ___ _ _    __  / / ___   ____&&&n" +
            " / // // // / / _ \\ / _ `// -_)/ _ \\ / _ \\     / /__   / __// _ `/| |/|/ / / / / -_) / __/&&&n" +
            "/____/ \\_,_/ /_//_/ \\_, / \\__/ \\___//_//_/     \\___/  /_/   \\_,_/ |__,__/ /_/  \\__/ /_/   &&&n" +
            "                   /___/                                                                  &&&n";

    private String[] menuText ={"1: Play","2: Settings","3: Exit"};
    private String[] menuDifficulty ={"Difficulty","1: Easy", "2: Medium","3: Hard","4: Hardcore"};
    private String[] menuClass ={"Class","1: Warrior", "2: Archer","3: Wizard"};


    private String deadText =
            "▓██   ██▓ ▒█████   █    ██    ▓█████▄  ██▓▓█████ ▓█████▄                \n" +
            " ▒██  ██▒▒██▒  ██▒ ██  ▓██▒   ▒██▀ ██▌▓██▒▓█   ▀ ▒██▀ ██▌               \n" +
            "  ▒██ ██░▒██░  ██▒▓██  ▒██░   ░██   █▌▒██▒▒███   ░██   █▌               \n" +
            "  ░ ▐██▓░▒██   ██░▓▓█  ░██░   ░▓█▄   ▌░██░▒▓█  ▄ ░▓█▄   ▌               \n" +
            "  ░ ██▒▓░░ ████▓▒░▒▒█████▓    ░▒████▓ ░██░░▒████▒░▒████▓  ██▓  ██▓  ██▓ \n" +
            "   ██▒▒▒ ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒     ▒▒▓  ▒ ░▓  ░░ ▒░ ░ ▒▒▓  ▒  ▒▓▒  ▒▓▒  ▒▓▒ \n" +
            " ▓██ ░▒░   ░ ▒ ▒░ ░░▒░ ░ ░     ░ ▒  ▒  ▒ ░ ░ ░  ░ ░ ▒  ▒  ░▒   ░▒   ░▒  \n" +
            " ▒ ▒ ░░  ░ ░ ░ ▒   ░░░ ░ ░     ░ ░  ░  ▒ ░   ░    ░ ░  ░  ░    ░    ░   \n" +
            " ░ ░         ░ ░     ░           ░     ░     ░  ░   ░      ░    ░    ░  \n" +
            " ░ ░                           ░                  ░        ░    ░    ░ ";

    private String gameOverText=
            " ▄████  ▄▄▄       ███▄ ▄███▓▓█████     ▒█████   ██▒   █▓▓█████  ██▀███  \n" +
            " ██▒ ▀█▒▒████▄    ▓██▒▀█▀ ██▒▓█   ▀    ▒██▒  ██▒▓██░   █▒▓█   ▀ ▓██ ▒ ██▒\n" +
            "▒██░▄▄▄░▒██  ▀█▄  ▓██    ▓██░▒███      ▒██░  ██▒ ▓██  █▒░▒███   ▓██ ░▄█ ▒\n" +
            "░▓█  ██▓░██▄▄▄▄██ ▒██    ▒██ ▒▓█  ▄    ▒██   ██░  ▒██ █░░▒▓█  ▄ ▒██▀▀█▄  \n" +
            "░▒▓███▀▒ ▓█   ▓██▒▒██▒   ░██▒░▒████▒   ░ ████▓▒░   ▒▀█░  ░▒████▒░██▓ ▒██▒\n" +
            " ░▒   ▒  ▒▒   ▓▒█░░ ▒░   ░  ░░░ ▒░ ░   ░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░░ ▒▓ ░▒▓░\n" +
            "  ░   ░   ▒   ▒▒ ░░  ░      ░ ░ ░  ░     ░ ▒ ▒░    ░ ░░   ░ ░  ░  ░▒ ░ ▒░\n" +
            "░ ░   ░   ░   ▒   ░      ░      ░      ░ ░ ░ ▒       ░░     ░     ░░   ░ \n" +
            "      ░       ░  ░       ░      ░  ░       ░ ░        ░     ░  ░   ░     \n" +
            "                                                     ░                   ";

    private String winText =
            "            /¯¯ \\\u0091                  /¯¯¯\\ '                    /\\ '                                             /\\'\u0082                              /\\\u0082                    /\\\u0082             \n" +
            "           |\\      \\'               /         \\\u0082                 /    \\     '                                     /    \\               /\\'\u0082         /    \\\u0082                /    \\ \u0082          \n" +
            "           |:|      |             /            '\\°              |\\      \\\u0082                                       |\\      \\'           /    \\      /      /|              /        \\\u0091         \n" +
            "           |/      /|\u0091           |        |\\      \\°            |:|      |    /'\\\u0082                                |:|      |          |\\      \\°  |      |:'|             |\\          \\        \n" +
            "          /      /::| /¯¯¯'/|  |        |::\\      \\ '\u0082         |/      /|  /    \\                               |/      /|          |:|      '|  |      |:'|           /\\|::\\         '\\  '    \n" +
            "         |      |:::/      /::|  |\\       '\\:::\\      \\ '       /      /::| |\\      \\                            /      /::|          |/      /|  |\\      \\/         /    \\:::\\         \\\u0082    \n" +
            "         |\\      \\/      /::::|\u0091 |::\\       '\\::|      |      /      /::::| |:|      '|                         /      /::::|         /      /::|\u0091 |::\\      \\      /        \\:::\\        '\\ ° \n" +
            "         |::\\___/|    |::::/\u0091  |::::\\       '\\|      |    /      /:::::/  |/      /|                       /      /:::::/        /      /::::|' |:::|      |'    |\\          \\::|         |'  \n" +
            "   /¯¯¯¯¯\\:::|/    /|::/      \\:::::\\            /|  /      /:::::/'  /      /::|'\u0082                    /      /:: /¯¯¯|    /      /:::::/ °\\:::|      |°   |:|       |\\  \\/        /|\u0091  \n" +
            " /       /|\\   \\/    /::|/\u0091         \\:::::\\____ /::| |      |:::::/  /      /::::|'\u0082                   |      |:::/   /|  |  /      /:::::/°     \\/      /|    |/       /|::\\____ /::|'  \n" +
            "|       |:'|::\\___/:::'|             \\::::|::::::|:::'| |\\      \\::/_/      (:::::/                     |\\      \\/   /::|  |/      /:::::/       /      /::|   /       /::|:::|::::::|:::|\u0091  \n" +
            "|\\     /|:'|:::|::::|::::/               \\::|::::::|::/\u0091 '|::\\______/|\\    /|::/\u0091                      |::\\____/::::|____ /:::::/\u0091       |\\    /::::|° |\\     /::::|\\::|::::::|::/\u0091   \n" +
            "|::\\ /::|'/ \\::|::::|::/\u0091                  \\|::::::|/\u0091   '|:::|:::::::::|:|::\\/::|/\u0091                        |:::|::::::|::::/|:::::::|::::/'         |::\\/:::::/   |::\\ /:::::/   \\|::::::|/  '   \n" +
            "|:::|:::|    '\\|::::|/                       ¯¯¯'       \\::|:::::::::|:|::|:::|\u0091                          \\::|::::::|::/  |:::::::|::/'\u0082          |:::|::::/ '\u0082  |:::|::::/       ¯¯¯        \n" +
            " \\::|::/       ¯¯                         \u0091              \\|:::::::::|/\\::|::/   °                         \\|::::::|/    |:::::::|/'\u0082             \\::|::/       \\::|::/                      \n" +
            "   \\|/'                                                \u0091     ¯¯¯¯¯    \\|/                                 ¯¯¯       ¯¯¯¯                  \\|/           \\|/                        \n";

    public void displayMenu(){
        clearScreen();
        constructEnvironment(titleText, screenHeight/2);
        constructEnvironment(constructBox(menuText), screenHeight/4);
        constructEnvironment("-- Press a number --",5);
    }

    public void displayDifficulty(){
        clearScreen();
        constructEnvironment(titleText, screenHeight/2);
        constructEnvironment(constructBox(menuDifficulty), screenHeight/4);
        constructEnvironment("-- Press a number --",5);
    }

    public void displayClass() {
        clearScreen();
        String message = "Hello "+ Game.getInstance().getName() +" nice to meet you. I'm Idony Miracle your playmaker and I will help you to find the holy graal";
        constructEnvironment(titleText, screenHeight/2);
        constructEnvironment(message, screenHeight/4);
        constructEnvironment(constructBox(menuClass), screenHeight/4);
        constructEnvironment("-- Enter a number --",5);
    }


    public void displayName(){
        clearScreen();
        constructEnvironment(titleText, screenHeight/2);
        constructEnvironment("'_ _ _ _ _ _ _'", screenHeight/4);
        constructEnvironment("-- Enter your name --",5);
    }

    public void displayGame(String description, String[] choice){
        clearScreen();
        constructEnvironment(description, screenHeight/2);
        constructEnvironment(constructBoxGame(choice), screenHeight/4);
        constructEnvironment("-- Press a number or 0 change room--",5);
    }

    public void displayInventory(String description, String[] shop, String[] choice){
        clearScreen();
        constructEnvironment(description, screenHeight/5);
        constructEnvironment(constructBox(shop), screenHeight/5);
        constructEnvironment(constructBoxGame(choice), screenHeight/5);
        constructEnvironment("-- Press a number or 0 change room--",5);
    }

    public void displayWin(){
        clearScreen();
        constructEnvironment(winText, screenHeight/5);
    }

    public void constructEnvironment(String message, int size){

        String[] listMessage = message.split("&&&n");
        for (int i = 0; i < size ;i++){
            if(i == size/5) {
                for (int j = 0; j < listMessage.length; j++) {
                    for (int y = 0; y < (screenLength - listMessage[j].length()) / 2; y++) {
                        System.out.print(" ");
                    }
                    System.out.println(listMessage[j]);
                    i+=1;
                }
            }else{
                System.out.println("");
            }
        }
    }

    public String constructBox(String[] messageInfo) {
        int numberLine = messageInfo.length+2;
        int sizeLength = 0;

        for (int i = 0; i < messageInfo.length; i++) {
            if(messageInfo[i].length() > sizeLength) sizeLength = messageInfo[i].length();
        }
        sizeLength += 7;
        String text = "";
        int cnt = 0;

        for (int i = 0; i < numberLine; i++){
            if(i == 0 || i == numberLine-1){

                text = repeatChar(text,sizeLength,'-');

                text+= "&&&n";
            }else{
                text+= "| " + messageInfo[cnt];
                int newSizeLength = sizeLength - 4 - messageInfo[cnt].length();

                text = repeatChar(text,newSizeLength,' ');

                text+= " |&&&n";
                cnt++;
            }
        }
        return text;
    }

    public String constructBoxGame(String[] messageInfo) {
        int numberLine = (messageInfo.length/2)+2;
        int sizeLength =  Game.getInstance().getGameInfo().length() + 4;

        String text = "";
        int cnt = 0;

        text = repeatChar(text,sizeLength,'-');

        text += "&&&n| " + Game.getInstance().getGameInfo()+ " |&&&n";

        for (int i = 0; i < numberLine; i++){
            if(i == 0 || i == numberLine-1){

                text = repeatChar(text,sizeLength,'-');

                text+= "&&&n";
            }else{
                text+= "| " + messageInfo[cnt];

                int newSizeLength = (sizeLength/2) - 2 - messageInfo[cnt].length();

                text = repeatChar(text,newSizeLength,' ');
                text += messageInfo[cnt+1];

                newSizeLength = sizeLength - 4 - messageInfo[cnt].length() - messageInfo[cnt+1].length() - newSizeLength;

                text = repeatChar(text,newSizeLength,' ');
                text+= " |&&&n";
                cnt+=2;
            }
        }
        return text;
    }

    private String repeatChar(String text, int size, char character){
        for (int j = 0; j < size; j++) {
            text+= character;
        }
        return text;
    }

    public void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception E)
        {
            System.out.println(E);
        }
    }
}
