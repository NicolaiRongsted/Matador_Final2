package org.example;

public class Gamestates {
    public Player[] players;
    public boolean Forceroll = false;
    public int[] positions;

    public Gamestates(boolean Forceroll, int[] positions, int[] balance){
        this.Forceroll = Forceroll;
        positions = new int[4];
    }
}
