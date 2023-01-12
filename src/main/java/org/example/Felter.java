package org.example;
import gui_main.GUI;
import static org.example.MonopolyGUI.gui;

public class Felter {
    private int[] leje;
    private int housecost;
    private int position;
    private int owner = 5;
    private int rentamounts = 5;
    private int houses = 0;
    public Felter(int housecost, int leje, int leje1, int leje2, int leje3, int leje4, int position){
        this.leje = new int[]{leje, leje1, leje2, leje3, leje4};
        this.housecost = housecost;
        this.position = position;
    }

    public int getOwner(){return owner;}
    public void setOwner(int owner){this.owner = owner;}
    public int getRent(){
        return leje[houses];
    }

    public void setHouses(int amount){
        houses = amount;
    }
    public int getHouses(){
        return houses;
    }
}
