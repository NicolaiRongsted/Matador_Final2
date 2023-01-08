package org.example;

public class Player {
    private int position;
    private String name;
    private boolean jailed = false;
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
    public void setJailed(){
        this.jailed = !jailed;
    }
    public boolean getJailed(){
        return jailed;
    }
}
