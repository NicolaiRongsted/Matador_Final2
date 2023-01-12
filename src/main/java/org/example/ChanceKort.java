package org.example;

public class ChanceKort extends Kort {

    int cardNumber;
    int cardValue;
    int cardPosition;
    int caseNumber;

    public ChanceKort(String description, KortType chanceKort, int cardNumber, int cardValue, int cardPosition, int caseNumber) { //her er vores chancekort som public med int's til vlaue og number
        super(description, chanceKort);
        this.cardNumber = cardNumber;
        this.cardValue = cardValue;
        this.cardPosition = cardPosition;
        this.caseNumber = caseNumber;
    }
}
