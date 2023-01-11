package org.example;

public class Gamestate extends DefaultGamestate {
    int[] forceRoll;
    int positions;
    private boolean forceroll;
    private boolean forceposition;
    private boolean forcedouble;
    private boolean injail;
    public Gamestate(int caseNumber, boolean forceroll, boolean forcedouble, int[] forceRolls, boolean forceposition, int positions, boolean injail){
        super(caseNumber);
        this.forceRoll = forceRolls;
        this.positions = positions;
        this.forceroll = forceroll;
        this.forceposition = forceposition;
        this.forcedouble = forcedouble;
        this.injail = injail;
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



}
