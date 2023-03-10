package org.example;

public class Player {
    private int position;
    private String name;

    private int x = 0;
    private boolean isAI = false;
    private int[] owned = new int[30];

    private boolean jailed = false;
    private boolean active = true;
    public Player(int position, String name){
        this.position = position;
        this.name = name;
    }
    public void setPosition(int terningkast){
        position =+ terningkast;
    }
    public int getPosition(){return position;}
    public void forcePosition(int pos){position = pos;}
    public String getName(){
        return name;
    }
    public void setJailed(){
        this.jailed = !jailed;
    }
    public void setActive(){
        this.active = false;
        this.owned = new int[0];
        this.x = 0;
    }
    public boolean getActive(){return active;}
    public boolean getJailed(){
        return jailed;
    }
    public void ai(){
        this.isAI = true;
    }
    public boolean isAI(){
        return isAI;
    }

    public void setOwned(int position){
        this.owned[x] = position;
        x++;
    }

    public int[] getOwned(){return owned;}
}



