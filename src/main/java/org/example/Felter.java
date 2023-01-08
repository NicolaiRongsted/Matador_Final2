package org.example;
import gui_main.GUI;
import static org.example.MonopolyGUI.gui;

public class Felter {
    private int position;
    private int leje;
    private int kost;
    private Player ejer;
    public Felter(int position, int leje, int kost){
        this.position = position;
        this.leje = leje;
        this.ejer = null;
    }
}
