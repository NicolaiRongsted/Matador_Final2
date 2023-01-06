package org.example;

public class GameController {
    MonopolyGUI game = new MonopolyGUI();
    public void play(){
        game.GUIstartup();
        CreatePlayers();
        new bræt();

    }
    private void CreatePlayers(){
        game.GUIPlayerstart();
    }
    private void PlayRound(){}

    private void Movetofield(){}


}
