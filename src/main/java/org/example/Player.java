package org.example;

public class Player {
    private int position;
    private String name;
    public Player(int position, String name){
        this.position = position;
        this.name = name;
    }
    public void setPosition(int terningkast){
        position =+ terningkast;
    }
    public int getPosition(){return position;}
    public String getName(){
        return name;
    }
}
