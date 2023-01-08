package org.example;

import gui_main.GUI;

public class GameController {
    MonopolyGUI game = new MonopolyGUI();
    boolean playing = true;
    Terning terning1 = new Terning();
    Terning terning2 = new Terning();
    private int roll1;
    private int roll2;
    public void play(){
        game.GUIstartup();
        CreatePlayers();
        PlayRound();
    }

    private void CreatePlayers(){
        game.GUIPlayerstart();
    }


    private void PlayRound(){
        int Player = 0;
        while (playing) {
            //skal bestemme hvilken spillers tur det er
            if (Player > 3){
                Player = 0;
            }
            //Tjekke om spiller er i fængsel (bedre at gøre der hvor man ruller og hvis man skal rykke)
            //Hvis spiller er i fængsel Slå 2 ens eller betale og miste tur(Igen bedre i der hvor man opdaterer positionen eller i en seperat funktion, men ikke her.)
            //skal bede en spiller om at slå
            game.showMessage("Det er Spilleren " + game.getName(Player) + "'s tur");
            //skal slå med terninger
            //skal vise hvad man slog (At vise hvad der bliver slået er nok også bedst at gøre i roll.)
            //Skal rykke på spilleren?
            game.Updateposition(Player, roll());
            //Over start modtage penge opdatere balance

            //game.Updatebalance(+4000, Player);

            //Indkomstskat betale bede spiller om at vælge betale 10% eller 200 og opdatere balance
            //Hvis fængsel låse spiller indtil ude
            //Hvis u-købt felt bede spiller om at købe og opdatere balance
            //Hvis købt felt betale leje og opdatere balance
            //Hvis chance felt trække kort
            //Udføre chancekort
            //skal gå videre til næste spiller
            game.showMessage("Næste spillers tur");
            //
            Player = (Player + 1) % 4;
        }
    }
    private void Movetofield(){

    }
    private void Landonfield(int PlayerID, int position){

    }
    public int roll(){ //Ud af MonopolyGUI og ind i GameController
        roll1 = terning1.roll();
        roll2 = terning2.roll();
        int rolltot = roll1 + roll2;
        game.showDice(roll1, roll2);
        return rolltot;
    }
}
