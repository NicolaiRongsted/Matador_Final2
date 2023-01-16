package org.example;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MonopolyGUI {
    private GamestateLoader gamestateLoader;
    public Gamestate gamestates[] = gamestateLoader.getGamestates();
    public static GUI gui = new GUI();
    public ArrayList<String> colors = new ArrayList<>(Arrays.asList("cyan", "magenta", "lightgray", "black"));
    static GUI_Player[] player;
    GUI_Field start = gui.getFields()[0];
    public static Player[] players;
    public GUI GUIstartup(){
        return gui;
    }
    public static int playeramount;
    public int aiamount;
    public void GUIPlayerstart(boolean testscenario, int startposition){
        bræt.Board();
        start = gui.getFields()[startposition];
        if(!testscenario){
            String playeramountstring = gui.getUserSelection("How many players?", "1", "2", "3", "4");
            playeramount = Integer.parseInt(playeramountstring);
        }else{
            playeramount = 2;
        }
        boolean ai = Yes_or_no("Du har valgt " + playeramount + "Antal spillere, vil du gerne fylde resten af pladserne med AI?");
        if(ai){
            aiamount = 4 - playeramount;
            playeramount = 4;
        }
        player = new GUI_Player[playeramount];
        players = new Player[playeramount];
        for (int i = 0; i < playeramount; i++){
            String playername = gui.getUserString("Whats the name of player " + (i + 1) + "?");
            String chosenColor = gui.getUserSelection("Hvilken farve vil du gerne have?", colors.toArray(new String[colors.size()]));
            colors.remove(chosenColor);
            players[i] = new Player(0, playername);
            player[i] = new GUI_Player(playername, 30000);
            gui.addPlayer(player[i]);
            if (chosenColor.equals("cyan")){player[i].getCar().setPrimaryColor(Color.cyan);
            }else if(chosenColor.equals("magenta")){player[i].getCar().setPrimaryColor(Color.magenta);
            }else if(chosenColor.equals("lightgray")){player[i].getCar().setPrimaryColor(Color.LIGHT_GRAY);
            }else {player[i].getCar().setPrimaryColor(Color.black);}
            player[i].getCar().setPosition(start);
        }
        for (int i = 4 - aiamount; i < playeramount; i++){
            players[i].ai();
        }

    }

    public void Updatebalance(int leje, int id){ // Updatebalance, fungerer på den måde at man sætter to parameter den skal bruge. En leje og id på personen, som er player: 0, 1, 2 ,
                                                            // Koden er derfor lavet på den måde, at man kalder på playerens id, og derfra sætter playerens balance, udfra hvad playerens
        player[id].setBalance(player[id].getBalance()+leje); // balance er i forvejen, og ligger lejen til eller trækker fra, alt afhængig af om det leje man skal betale eller få
        if(player[id].getBalance() < 0){
            gui.showMessage("Spilleren " + player[id].getName() + " Er desværre gået bankeråt og er derfor ude af spillet!");
            players[id].setActive();
            int[] array = players[id].getOwned();
            for (int i = 0; i < array.length; i++){
            }
            playeramount = playeramount - 1;
        }
    }

    public void Updateposition(int ID, int terningkast){ //Opdater positionen på gui
        players[ID].setPosition(players[ID].getPosition() + terningkast);
        if (players[ID].getPosition() >= 40){
            players[ID].setPosition(players[ID].getPosition() % 40);
            Updatebalance(4000, ID);
        }
        GUI_Field field = gui.getFields()[players[ID].getPosition()];
        player[ID].getCar().setPosition(field);
    }
    public void Setposition(int ID, int position){
        players[ID].forcePosition(position);
        GUI_Field field = gui.getFields()[position];
        player[ID].getCar().setPosition(field);
    }


    public void showMessage(String msg){ //GUI er lavet statisk og kan tilgås fra andre klasser. og der er derfor ikke behov for denne.
        gui.showMessage(msg);
    }

    public void showDice(int dice1, int dice2){ //skal hedde noget andet end getFace da det ikke er det den gør.
        gui.setDice(dice1, dice2);
    }
    public String getName(int id){
        return players[id].getName();
    }


    public boolean Yes_or_no(String message){
        String yes = "Yes";
        String no = "No";
        String input = gui.getUserSelection(message, yes, no);
        return input.equals(yes);
    }

    public void displayChanceCard(String chancekort){
        gui.displayChanceCard(chancekort);

    }

    public boolean checkActivePlayer(int id){
        return players[id].getActive();
    }
    public void clearOwner(){}

}
