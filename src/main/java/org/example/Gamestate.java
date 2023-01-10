package org.example;

public class Gamestate extends DefaultGamestate {
    int[] forceRoll;
    public Gamestate(int caseNumber, int[] forceRolls){
        super(caseNumber);
        this.forceRoll = forceRolls;
    }
    public int[] getForceRoll(){return forceRoll;}


}
