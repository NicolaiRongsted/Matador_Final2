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
    private String color;
    private int cost;
    String name;
    public Felter(String name, String color, int cost, int housecost, int leje, int leje1, int leje2, int leje3, int leje4, int leje5, int position){
        this.leje = new int[]{leje, leje1, leje2, leje3, leje4, leje5};
        this.housecost = housecost;
        this.position = position;
        this.color = color;
        this.cost = cost;
        this.name = name;
    }
    public String getColor(){
        return color;
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
