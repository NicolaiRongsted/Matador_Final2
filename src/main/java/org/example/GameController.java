package org.example;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_main.GUI;

import static org.example.MonopolyGUI.gui;
import static org.example.MonopolyGUI.*;

public class GameController {
    SpecialFelter chancekort = new SpecialFelter();
    MonopolyGUI game = new MonopolyGUI();
    private boolean Customgamestate = false;
    boolean playing = true;
    private Gamestate save;
    public Gamestate gamestates[] = GamestateLoader.getGamestates();
    private int gamestate;
    Terning terning1 = new Terning();
    int roll = 0;
    Terning terning2 = new Terning();
    private int roll1;
    private int startpos = 0;
    private int roll2;
    public void play(){
        setGamestate();
        if(!Customgamestate){
            game.GUIstartup();
            game.GUIPlayerstart(false, startpos);
            PlayRound();
        }else{
            gamestate -= 3;
            startpos = gamestates[gamestate].getPosition();
            game.GUIstartup();
            game.GUIPlayerstart(true, startpos);
            game.Setposition(0, startpos);
            game.Setposition(1, startpos);
            if(gamestates[gamestate].getBalance() != 0){
                game.Updatebalance(gamestates[gamestate].getBalance()-30000, 0);
                game.Updatebalance(gamestates[gamestate].getBalance()-30000, 1);
            }
            if(gamestates[gamestate].getInjail()){
                players[0].setJailed();
                players[1].setJailed();
            }
            PlayRound();
        }
    }


    private void PlayRound(){
        int Player = 0;
        while (playing) {
            boolean gotOut = false;

            while (!game.checkActivePlayer(Player)){
                Player += 1;
            }

            if(playeramount <= 1){
                game.showMessage("Alle andre spillere er gaaet bankeraat og spilleren " + players[Player].getName() + " har vundet!");
                break;
            }
            if (Player > 3) { // Bestemmer hvilken spillers tur det er.
                Player = 0;
            }
            game.showMessage("Det er Spilleren " + game.getName(Player) + "'s tur");
            //Tjekke om spiller er i fængsel (bedre at gøre der hvor man ruller og hvis man skal rykke)
            //Hvis spiller er i fængsel Slå 2 ens eller betale og miste tur(Igen bedre i der hvor man opdaterer positionen eller i en seperat funktion, men ikke her.)
            //skal bede en spiller om at slå
            //skal slå med terninger
            //skal vise hvad man slog (At vise hvad der bliver slået er nok også bedst at gøre i roll.)
            //Skal rykke på spilleren?
            if (!players[Player].getJailed()) {
                System.out.println("Player not in jail");
                if(Customgamestate){
                    System.out.println("Custom game state detected.");
                    System.out.println(gamestate);
                    int rolls[] = gamestates[gamestate].getForceRoll();
                    game.Updateposition(Player, rolls[roll]);
                    forceroll(rolls[roll]);
                    Landonfield(Player, players[Player].getPosition());
                    roll = roll + 1;
                    if (roll >= rolls.length){
                        Customgamestate = false;
                        System.out.println("Exiting custom game state");
                    }
                }else {
                    game.Updateposition(Player, roll());
                    Landonfield(Player, players[Player].getPosition());
                    //Over start modtage penge opdatere balance
                }
            }
            else {
                game.showMessage("Du er er i faengsel, slå to ens for at komme ud.");
                if(!Customgamestate){
                    roll();
                }else{
                    int rolls[] = gamestates[gamestate].getForceRoll();
                    forceroll(rolls[roll]);
                    roll = roll+1;
                    if(roll >= rolls.length){
                        Customgamestate = false;
                    }
                }
                if (roll1==roll2){
                    players[Player].setJailed();
                    game.Updateposition(Player, roll1+roll2);
                    Landonfield(Player, MonopolyGUI.players[Player].getPosition());
                    gotOut=true;
                }
            }
            int i = 0; // Tæller til at der kun er 2 ekstra slag
            while (roll1 == roll2 && !MonopolyGUI.players[Player].getJailed() && !gotOut && roll1 != 0) {
                System.out.println(roll1);
                System.out.println("Double roll detected");
                if (i == 2) {
                    players[Player].getJailed();
                    break;
                }
                game.showMessage("Der er blevet slået to ens, slå igen");
                game.Updateposition(Player, roll());
                Landonfield(Player, players[Player].getPosition());
                if (roll1 != roll2) {
                    break;
                }
                i++;
            }
            //Chancekort array fejl
            //komme i faengsel naar de har slaaet 2 ens igen
            //Chancekort rykke virker ikke
            //Ingen besked naar man kommer i faengsel
            //Traekker 4 kort



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
    private void Landonfield(int PlayerID, int position){

        if (position == 30){
            game.showMessage("Spilleren " + (PlayerID+1) + " er blevet faengslet!");
            players[PlayerID].setJailed();
            game.Setposition(PlayerID, 10);
            System.out.println("Spilleren landte på fængsel");
        }
        else if (position == 4 || position == 38){
            game.showMessage("Ej hvor ærgerligt du landte desværre på en af betal skat felterne, og skal derfor betale 2000!");
            game.Updatebalance(-2000, PlayerID);
            System.out.println("Spilleren landte på feltet med en ekstraordinær skat");;
        }
        else if (position == 2 || position == 7 || position == 17 || position == 22 || position == 33 || position == 36){
            int ChancekortTræk = chancekort.getChancekort();
            //Traek chancekort
            game.displayChanceCard(chancekort.getDescription(ChancekortTræk));
            handleChanceKort(ChancekortTræk,PlayerID, chancekort.getCaseNumber(ChancekortTræk));
            System.out.println("Spilleren landte på chancekort");
        }
        else if(position == 10 || position == 20 || position == 0 || position == 40){
            game.showMessage("Du landte på et feldt hvor der ikke sker noget!");
        }
        else {
            GUI_Field field = gui.getFields()[position];
            GUI_Ownable ownable = (GUI_Ownable) field;
            if (ownable.getOwnerName() == null){
                boolean buy = game.Yes_or_no("Vil du gerne købe feltet");
                if(buy){
                    //Vil gerne koebe
                    int pris = Integer.parseInt(field.getSubText());
                    game.Updatebalance(-pris, PlayerID);
                    ownable.setOwnerName(game.getName(PlayerID));
                    players[PlayerID].setOwned(position);
                }
                else {
                    //Vil ikke koebe
                }
            }
            else{
                if(ownable.getOwnerName() != game.getName(PlayerID)){
                    int Owner = getOwner(ownable.getOwnerName());
                    game.showMessage("Det er spilleren " + ownable.getOwnerName() + " Der ejer grunden, du skal derfor betale " + bræt.felter[position].getRent());
                    game.Updatebalance(bræt.felter[position].getRent(), PlayerID); //betaling, mangler at give spilleren der ejer grunden pengene.
                    game.Updatebalance(bræt.felter[position].getRent(), Owner);
                } else if (ownable.getOwnerName().equals(game.getName(PlayerID))) {
                    game.showMessage("Du ejer selv feltet!");
                    int[] array = bræt.getColors(bræt.felter[position].getColor());
                    int amountowned = 0;
                    for (int i = 0; i < array.length; i++){
                        field = gui.getFields()[array[i]];
                        ownable = (GUI_Ownable) field;
                        if(ownable.getOwnerName().equals(game.getName(PlayerID))){
                            amountowned = amountowned + 1;
                        }
                    }
                    if(amountowned == array.length){
                        int houseprice = bræt.felter[position].getHousecost();
                        boolean buildhouse = game.Yes_or_no("Du ejer alle felterne i denne farve, vil du gerne bygge huse? Det ville koste: " + array.length*houseprice);
                        if(buildhouse){
                            game.Updatebalance(array.length*houseprice, PlayerID);
                            for (int i = 0; i < array.length; i++){
                                bræt.felter[array[i]].setHouses(bræt.felter[array[i]].getHouses()+1);
                            }
                        }
                    }
                }
            }
        }
    }

    public int roll() { //Ud af MonopolyGUI og ind i GameController
        roll1 = terning1.roll();
        roll2 = terning2.roll();
        int rolltot = roll1 + roll2;
        game.showDice(roll1, roll2);
        return rolltot;
    }
    public void forceroll(int roll){
        if(!gamestates[gamestate].getForceDouble()){
            int forceroll1 = roll/2;
            int forceroll2 = roll-forceroll1;
            if(forceroll2 == forceroll1){
                forceroll1 -= 1;
                forceroll2 += 1;
            }
            game.showDice(forceroll1, forceroll2);
        }else{
            roll1 = roll/2;
            roll2 = roll1;
            game.showDice(roll1, roll2);
        }
    }
    private void handleChanceKort(int cardNumber, int player, int caseNumber) { //logik til hvordan spillet skal håndtere når spilleren modtager chancekort
        switch (caseNumber){
            case 1 -> {
                game.Setposition(player,chancekort.getCardPositon(cardNumber)); //chancekort der ændrer position
            }
            case 2 -> {
                game.Updatebalance(chancekort.getCardValue(cardNumber),player); //chancekort der ændrer balance
            }
        }
    }
    private int getOwner(String name){
        int owner = 5;
        for (int i = 0; i < game.playeramount; i++){
            String temp = game.getName(i);
            if (temp == name){
                owner = i;
            }
        }
        return owner;
    }
    public void setGamestate(){
        System.out.println("setGamestate entered");
        boolean enterstate = !game.Yes_or_no("Would you like to load a custom game state?");
        if (enterstate){
            Customgamestate = false;
            System.out.println("Custom game state set to false");
        }
        else {
            gamestate = gui.getUserInteger("Which game state would you like to load?");
            for (int i = 0; i < gamestates.length; i++){
                if (gamestate - 3 == gamestates[i].getcaseNumber()){
                    System.out.println(gamestate);
                    Customgamestate = true;
                    System.out.println("Custom game state set to true;");
                }
            }
        }
    }
}
