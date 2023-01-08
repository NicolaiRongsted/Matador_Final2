package org.example;
public abstract class Gamestate {
    String name;
    public Gamestate(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}
