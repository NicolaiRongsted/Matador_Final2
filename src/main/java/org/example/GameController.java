package org.example;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static org.example.MonopolyGUI.gui;
import static org.example.MonopolyGUI.*;

public class GameController {
    SpecialFelter chancekort = new SpecialFelter();
    MonopolyGUI game = new MonopolyGUI();
    public int round = 1;
    private boolean Customgamestate = false;
    boolean playing = true;
    private SaveGame monopolyGame;
    public int Player = 0;
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
            if (players[Player].isAI()){

            }
            if (!players[Player].getJailed()) {
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
                }
            }
            else {
                String jail;
                if(!players[Player].isAI()){
                    jail = game.gui.getUserButtonPressed("Vil du gerne k??be dig ud eller pr??ve at sl?? 2 ens for at komme ud?", "K??be, Pris:1000", "Sl??");
                }else{
                    if(player[Player].getBalance() > 5000){
                        jail = "numse";
                    }else{
                        jail = "Sl??";
                    }
                }
                if(jail.equals("Sl??")){
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
                }else {
                    game.Updatebalance(-1000, Player);
                    players[Player].setJailed();
                    gotOut = true;
                }
            }
            int i = 0; // T??ller til at der kun er 2 ekstra slag
            while (roll1 == roll2 && !MonopolyGUI.players[Player].getJailed() && !gotOut && roll1 != 0) {
                System.out.println(roll1);
                System.out.println("Double roll detected");
                if (i == 2) {
                    players[Player].getJailed();
                    break;
                }
                game.showMessage("Der er blevet sl??et to ens, sl?? igen");
                game.Updateposition(Player, roll());
                Landonfield(Player, players[Player].getPosition());
                if (roll1 != roll2) {
                    break;
                }
                i++;
            }
            game.showMessage("N??ste spillers tur");
            //Skifter spiller, modulus er antallet af spillere der er valgt
            Player = (Player + 1) % game.playeramount;
            //round++;
            //UpdateInfo(Player);
            //if(round%10 == 0){
                //monopolyGame.saveGame();
            //}
        }
    }
    private void Landonfield(int PlayerID, int position){

        if (position == 30){
            game.showMessage("Spilleren " + (PlayerID+1) + " er blevet faengslet!");
            players[PlayerID].setJailed();
            game.Setposition(PlayerID, 10);
            System.out.println("Spilleren landte p?? f??ngsel");
        }
        else if (position == 4 || position == 38){
            game.showMessage("Ej hvor ??rgerligt du landte desv??rre p?? en af betal skat felterne, og skal derfor betale 2000!");
            game.Updatebalance(-2000, PlayerID);
            System.out.println("Spilleren landte p?? feltet med en ekstraordin??r skat");;
        }
        else if (position == 2 || position == 7 || position == 17 || position == 22 || position == 33 || position == 36){
            int ChancekortTr??k = chancekort.getChancekort();
            //Traek chancekort
            game.displayChanceCard(chancekort.getDescription(ChancekortTr??k));
            handleChanceKort(ChancekortTr??k,PlayerID, chancekort.getCaseNumber(ChancekortTr??k));
            System.out.println("Spilleren landte p?? chancekort");
        }
        else if(position == 10 || position == 20 || position == 0 || position == 40){
            game.showMessage("Du landte p?? et feldt hvor der ikke sker noget!");
        }
        else {
            GUI_Field field = gui.getFields()[position];
            GUI_Ownable ownable = (GUI_Ownable) field;
            if (br??t.felter[position].getOwner() == 5){
                if(!players[PlayerID].isAI()){
                    boolean buy = game.Yes_or_no("Vil du gerne k??be feltet");
                    if(buy){
                        if(player[PlayerID].getBalance() - br??t.felter[position].getPrice() < 0){
                            game.showMessage("Du har desv??rre ikke nok penge til at k??be feltet!");
                        }else{buyField(position, PlayerID);}
                    }
                    else {
                        //Vil ikke koebe
                    }
                }else{
                    if(br??t.felter[position].getPrice() < player[PlayerID].getBalance()/2){
                        buyField(position, PlayerID);
                    }
                }
            }
            else{
                if(br??t.felter[position].getOwner() != PlayerID){
                    game.showMessage("Det er spilleren " + ownable.getOwnerName() + " Der ejer grunden, du skal derfor betale " + br??t.felter[position].getRent());
                    game.Updatebalance(-br??t.felter[position].getRent(), PlayerID); //betaling, mangler at give spilleren der ejer grunden pengene.
                    game.Updatebalance(br??t.felter[position].getRent(), br??t.felter[position].getOwner());
                } else if (br??t.felter[position].getOwner() == PlayerID) {
                    game.showMessage("Du ejer selv feltet!");
                    int[] array = br??t.getColors(br??t.felter[position].getColor());
                    int amountowned = 0;
                    for (int i = 0; i < array.length; i++){
                        field = gui.getFields()[array[i]];
                        ownable = (GUI_Ownable) field;
                        if(ownable.getOwnerName() != null){
                            if(ownable.getOwnerName().equals(game.getName(PlayerID))){
                                amountowned = amountowned + 1;
                            }
                        }else  break;
                    }
                    if(amountowned == array.length){
                        int houseprice = br??t.felter[position].getHousecost();
                        boolean buildhouse = game.Yes_or_no("Du ejer alle felterne i denne farve, vil du gerne bygge huse? Det ville koste: " + array.length*houseprice);
                        if(buildhouse){
                            game.Updatebalance(array.length*houseprice, PlayerID);
                            for (int i = 0; i < array.length; i++){
                                if(br??t.felter[array[i]].getHouses() < 5){
                                    br??t.felter[array[i]].setHouses(br??t.felter[array[i]].getHouses()+1);
                                }
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
    private void handleChanceKort(int cardNumber, int player, int caseNumber) { //logik til hvordan spillet skal h??ndtere n??r spilleren modtager chancekort
        switch (caseNumber){
            case 1 -> {
                game.Setposition(player,chancekort.getCardPositon(cardNumber)); //chancekort der ??ndrer position
            }
            case 2 -> {
                game.Updatebalance(chancekort.getCardValue(cardNumber),player); //chancekort der ??ndrer balance
            }
            case 3 -> {
                game.Updateposition(player, chancekort.getCardPositon(cardNumber));
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

    public void buyField(int position, int player){
        game.Updatebalance(-br??t.felter[position].getPrice(), player);
        GUI_Ownable ownable = (GUI_Ownable) gui.getFields()[position];
        ownable.setOwnerName(game.getName(player));
        ownable.setBorder(game.player[player].getPrimaryColor());
        players[player].setOwned(position);
        br??t.felter[position].setOwner(player);
    }

    public void LoadGame(){
        boolean[] array = monopolyGame.getPlayerAI();
        int[] positions = monopolyGame.getPlayerPosition();
        for (int i = 0; i < playeramount; i++){
            player[i].setBalance(monopolyGame.getPlayerMoney(i));
            if(array[i]){
                players[i].ai();
            }
            players[i].setJailed();
            game.Setposition(i, positions[i]);
        }
        Player = monopolyGame.getCurrentPlayer();
        for (int i = 0; i < playeramount; i++){
            int[] ownedProperties = monopolyGame.getPlayerProperties(i);
            for (int j = 0; j < ownedProperties.length; j++){
                if (ownedProperties[j] == 0){
                    break;
                }
                GUI_Ownable ownable = (GUI_Ownable) gui.getFields()[ownedProperties[j]];
                ownable.setOwnerName(game.getName(i));
                ownable.setBorder(game.player[0].getPrimaryColor());
                players[i].setOwned(ownedProperties[j]);
                br??t.felter[ownedProperties[j]].setOwner(i);
            }
        }

    }

    public void UpdateInfo(int player){
        for (int i = 0; i < playeramount; i++){
            monopolyGame.setPlayerMoney(i, game.player[i].getBalance());
            monopolyGame.setPlayersInJail(i, players[i].getJailed());
            monopolyGame.setPlayerOrAi(i, players[i].isAI());
            monopolyGame.setPlayerPosition(i, players[i].getPosition());
        }
        monopolyGame.setPlayerProperties(players[0].getOwned(), players[1].getOwned(), players[2].getOwned(), players[3].getOwned());
        monopolyGame.setCurrentPlayer(player);
    }
}
