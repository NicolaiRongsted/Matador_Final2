package org.example;

public class GameController {
    MonopolyGUI game = new MonopolyGUI();
    public void play(){
        game.GUIstartup();
        CreatePlayers();

    }
    private void CreatePlayers(){
        game.GUIPlayerstart();
    }
    private void PlayRound(){}

    private void Movetofield(){}


}
