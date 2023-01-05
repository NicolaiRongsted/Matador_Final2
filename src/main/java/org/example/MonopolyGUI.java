package org.example;
import gui_main.GUI;

public class MonopolyGUI {
    private GUI gui;

    public boolean Yes_or_no(String message){
        String yes = "Yes";
        String no = "No";
        String input = gui.getUserSelection(message, yes, no);
        return input.equals(yes);
    }
}
