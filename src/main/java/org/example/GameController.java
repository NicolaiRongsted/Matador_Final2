package org.example;
import java.io.*;
import gui_main.GUI;

public class GameController {
    MonopolyGUI game = new MonopolyGUI();
    boolean playing = true;
    Felter[] felter = new Felter[40];
    public void play(){
        game.GUIstartup();
        Start();
        for (int i = 0; i < 5; i++){
            String[] test = bræt.getPris();
            System.out.println(test[i]); //virker
        }
    }
    private void Start(){
        game.GUIPlayerstart();
        //InitializeFields();
    }


    private void PlayRound(){

        while (playing) {
            //skal bestemme hvilken spillers tur det er

            //Tjekke om spiller er i fængsel (bedre at gøre der hvor man ruller og hvis man skal rykke)

            //Hvis spiller er i fængsel Slå 2 ens eller betale og miste tur(Igen bedre i der hvor man opdaterer positionen eller i en seperat funktion, men ikke her.)

            //skal bede en spiller om at slå
            game.showMessage("Slå med terningerne");
            //skal slå med terninger
            game.roll();
            //skal vise hvad man slog (At vise hvad der bliver slået er nok også bedst at gøre i roll.)
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

    private void Movetofield(){

    }

    private void Landonfield(int PlayerID, int position){
    }

    private void InitializeFields(){
    }

}
