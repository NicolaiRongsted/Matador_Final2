package org.example;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import java.io.*;

public class MonopolyGUI {
    private GUI gui = new GUI();
    static GUI_Player[] player = new GUI_Player[4];
    GUI_Field start = gui.getFields()[0];
    public GUI GUIstartup(){
        return gui;
    }
    public void GUIPlayerstart(){
        String playeramountstring = gui.getUserSelection("How many players?", "2", "3", "4");
        int playeramount = Integer.parseInt(playeramountstring);
        for (int i = 1; i < playeramount + 1; i++){
            String playername = gui.getUserString("Whats the name of player " + i + "?");
            player[i - 1] = new GUI_Player(playername, 30000);
            gui.addPlayer(player[i - 1]);
            player[i - 1].getCar().setPosition(start);
        }
    }

    public void Updatebalance(){ //Opdater penge på gui

    }

    public void Updateposition(int ID){ //Opdater positionen på gui

    }





    public boolean Yes_or_no(String message){
        String yes = "Yes";
        String no = "No";
        String input = gui.getUserSelection(message, yes, no);
        return input.equals(yes);
    }
}
