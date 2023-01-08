package org.example;

import gui_main.GUI;

public class GameController {
    SpecialFelter chancekort = new SpecialFelter();
    MonopolyGUI game = new MonopolyGUI();
    boolean playing = true;
    Terning terning1 = new Terning();
    Terning terning2 = new Terning();
    private int roll1;
    private int roll2;

    public void play() {
        game.GUIstartup();
        CreatePlayers();
        PlayRound();
    }

    private void CreatePlayers() {
        game.GUIPlayerstart();
    }


    private void PlayRound() {
        int Player = 0;
        while (playing) {
            if (Player > 3) { // Bestemmer hvilken spillers tur det er.
                Player = 0;
            }
            game.showMessage("Det er Spilleren " + game.getName(Player) + "'s tur");
            //Tjekke om spiller er i fængsel (bedre at gøre der hvor man ruller og hvis man skal rykke)

            //Hvis spiller er i fængsel Slå 2 ens eller betale og miste tur(Igen bedre i der hvor man opdaterer positionen eller i en seperat funktion, men ikke her.)

            game.Updateposition(Player, roll());  // Flytter spilleren det der blev slået, og viser det i gui'en.

            //Over start modtage penge opdatere balance

            int i = 0; // Tæller til at der kun er 2 ekstra slag
            while (roll1 == roll2) {
                if (i == 2) {
                    //game.Updateposition();
                    break;
                }
                game.showMessage("Der er blevet to ens, slå igen");
                game.Updateposition(Player, roll());
                if (roll1 != roll2) {
                    break;
                }
                i++;
            }


            //game.Updatebalance(+4000, Player);

            //Indkomstskat betale bede spiller om at vælge betale 10% eller 200 og opdatere balance
            //Hvis fængsel låse spiller indtil ude
            //Hvis u-købt felt bede spiller om at købe og opdatere balance
            //Hvis købt felt betale leje og opdatere balance
            //Hvis chance felt trække kort
            //Udføre chancekort
            //skal gå videre til næste spiller
            game.showMessage("Næste spillers tur");
            //Skifter spiller, modulus er antallet af spillere der er valgt
            Player = (Player + 1) % game.playeramount;
        }
    }

    private void Movetofield() {

    }

    private void Landonfield(int PlayerID, int position) {

    }

    public int roll() { //Ud af MonopolyGUI og ind i GameController
        roll1 = terning1.roll();
        roll2 = terning2.roll();
        int rolltot = roll1 + roll2;
        game.showDice(roll1, roll2);
        return rolltot;
    }
    private void handleChanceKort(int cardNumber, int player, int cardValue, int cardPostion) { //logik til hvordan spillet skal håndtere når spilleren modtager chancekort
        switch (cardNumber){
            case 1 -> {
                game.Setposition(player,chancekort.getCardPositon(cardNumber)); //chancekort der ændrer position
            }

            case 2 -> {
                game.Updatebalance(player,chancekort.getCardValue(cardNumber)); //chancekort der ændrer balance
            }


        }
    }


}
