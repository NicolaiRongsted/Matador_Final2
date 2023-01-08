package org.example;

import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_main.GUI;

import static org.example.MonopolyGUI.gui;

public class GameController {
    SpecialFelter chancekort = new SpecialFelter();
    MonopolyGUI game = new MonopolyGUI();
    boolean playing = true;
    Terning terning1 = new Terning();
    Terning terning2 = new Terning();
    private int roll1;
    private int roll2;
    public void play(){
        //game.CustomGamestate();
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
            Landonfield(Player, MonopolyGUI.players[Player].getPosition());
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
            //Skifter spiller, modulus er antallet af spillere der er valgt
            Player = (Player + 1) % game.playeramount;
        }
    }
    private void Movetofield(){

    }
    private void Landonfield(int PlayerID, int position){

        if (position == 30){
            MonopolyGUI.players[PlayerID].setJailed();
            game.Setposition(PlayerID, 10);
            System.out.println("Spilleren landte paa faengsel");
        }
        else if (position == 4 || position == 38){
            game.Updatebalance(-2000, PlayerID);
            System.out.println("Spilleren landte paa skatte ting");;
        }
        else if (position == 2 || position == 7 || position == 17 || position == 22 || position == 33 || position == 36){
            //Traek chancekort
            System.out.println("Spilleren landte paa chancekort");
        }
        else if(position == 10 || position == 20 || position == 0 || position == 40){
            game.showMessage("Du landte p[ et feldt hvor der ikke sker noget!");
        }
        else {
            System.out.println("Spilleren landte paa en grund");
            GUI_Field field = gui.getFields()[position];
            GUI_Ownable ownable = (GUI_Ownable) field;
            if (ownable.getOwnerName() == null){
                boolean buy = game.Yes_or_no("Vil du gerne købe feltet");
                if(buy){
                    //Vil gerne koebe
                    int pris = Integer.parseInt(field.getSubText());
                    game.Updatebalance(-pris, PlayerID);
                    ownable.setOwnerName(game.getName(PlayerID));

                }
                else {
                    //Vil ikke koebe
                }
            }
            else{
                if(ownable.getOwnerName() != game.getName(PlayerID)){
                    game.showMessage("Det er spilleren " + ownable.getOwnerName() + " Der ejer grunden, du skal derfor betale " + ownable.getRent());
                    game.Updatebalance(Integer.parseInt(ownable.getRent()), PlayerID);
                }
                //betal leje til spilleren der ejer grunden.
            }
        }
    }
    public int roll(){ //Ud af MonopolyGUI og ind i GameController
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
