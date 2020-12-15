package Services;

import Models.Players;

public class PlayersService{

    public void gameOver(int pointOpen){
        if(pointOpen==0){
            System.out.println("GAME OVER");
        }
    }

    public void dead(Players players){
        if(players.getHealth()==0){
            System.out.println("Vous êtes mort");
            players.setPointOpen(-1);
        }
        if(players.getPointOpen()==-1){
            gameOver(0);
        }
    }
}
