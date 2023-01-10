package org.example;

public abstract class DefaultGamestate {
    int caseNumber;
    public DefaultGamestate(int casenumber){
        this.caseNumber = casenumber;
    }

    public int getcaseNumber() {
        return caseNumber-3;
    }
}
