package org.example;

public class Gamestate extends DefaultGamestate {
    int[] forceRoll;
    public Gamestate(int caseNumber, int numberOfForcerolls, int[] forceRolls){
        super(caseNumber);
        this.forceRoll = new int[numberOfForcerolls];
        for (int i = 0; i < numberOfForcerolls; i++){
            forceRoll[i] = forceRolls[i];
        }
    }

}
