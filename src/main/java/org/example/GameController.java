package org.example;

public class GameController {
    MonopolyGUI game = new MonopolyGUI();
    public void play(){
        game.GUIstartup();
        CreatePlayers();
        game.Updateposition(2);
    }
    private void CreatePlayers(){
        game.GUIPlayerstart();
        Player[] players;
    }
    private void PlayRound(){
    }

    private void Movetofield(){}

}
