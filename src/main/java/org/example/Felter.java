package org.example;
import gui_main.GUI;
import static org.example.MonopolyGUI.gui;

public class Felter {
    private int position;
    private int leje;
    private String navn;
    private Player ejer;
    public void Felter(int position, int leje, String navn){
        this.position = position;
        this.leje = leje;
        this.navn = navn;
        this.ejer = null;
    }



}
