package org.example;

public class Gamestate extends DefaultGamestate {
    int[] forceRoll;
    int positions;
    private boolean forceroll;
    private boolean forceposition;
    private boolean forcedouble;
    private boolean injail;
    private int balance;
    public Gamestate(int caseNumber, boolean forceroll, boolean forcedouble, int[] forceRolls, boolean forceposition, int positions, boolean injail, int balance){
        super(caseNumber);
        this.forceRoll = forceRolls;
        this.positions = positions;
        this.forceroll = forceroll;
        this.forceposition = forceposition;
        this.forcedouble = forcedouble;
        this.injail = injail;
        this.balance = balance;
    }
    public int[] getForceRoll(){return forceRoll;}
    public int getPosition(){
        return positions;
    }
    public boolean getForceDouble(){
        return forcedouble;
    }
    public boolean getInjail(){
        return injail;
    }
    public int getBalance(){
        return balance;
    }


}
