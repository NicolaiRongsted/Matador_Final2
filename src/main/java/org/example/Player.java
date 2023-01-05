package org.example;

public class Player {
    private int balance;
    private int SpillerLokation;
    public Player(){
        balance = 20;
    }
    public int getbalance() {
        return balance;
    }
    public void setbalance(int balance) {
        this.balance = balance;
    }
    public void setlocation(int location) {
        this.SpillerLokation = location;
    }
}
