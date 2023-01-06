package org.example;

import gui_main.GUI;

public class GameController {
    MonopolyGUI game = new MonopolyGUI();

    boolean playing = true;

    public void play(){
        game.GUIstartup();
        CreatePlayers();
        PlayRound();

    }
    private void CreatePlayers(){
        game.GUIPlayerstart();
    }


    private void PlayRound(){

        while (playing) {
            //skal bestemme hvilken spillers tur det er

            //Tjekke om spiller er i fængsel

            //Hvis spiller er i fængsel Slå 2 ens eller betale og miste tur

            //skal bede en spiller om at slå
            game.showMessage("Slå med terningerne");
            //skal slå med terninger
            game.roll();
            //skal vise hvad man slog
            game.getFace();
            //Skal rykke på spilleren?

            //Over start modtage penge opdatere balance

            //Indkomstskat betale bede spiller om at vælge betale 10% eller 200 og opdatere balance

            //Hvis fængsel låse spiller indtil ude

            //Hvis u-købt felt bede spiller om at købe og opdatere balance

            //Hvis købt felt betale leje og opdatere balance

            //Hvis chance felt trække kort
            //Udføre chancekort

            //skal gå videre til næste spiller
            game.showMessage("Næste spillers tur");

            //
        }

    }

    private void Movetofield(){}


}
