package org.example;
import gui_main.GUI;
import static org.example.MonopolyGUI.gui;

public class Felter {
    private int leje;
    private int leje1;
    private int leje2;
    private int leje3;
    private int leje4;
    private int housecost;
    private int position;
    private int owner = 5;
    public Felter(int housecost, int leje, int leje1, int leje2, int leje3, int leje4, int position){
        this.leje = leje;
        this.leje1 = leje1;
        this.leje2 = leje2;
        this.leje3 = leje3;
        this.leje4 = leje4;
        this.housecost = housecost;
        this.position = position;
    }

    public int getOwner(){return owner;}
    public void setOwner(int owner){this.owner = owner;}


}
