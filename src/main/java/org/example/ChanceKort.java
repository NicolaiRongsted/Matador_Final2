package org.example;

public class ChanceKort extends Kort {

    int cardNumber;
    public ChanceKort(String description, KortType chanceKort, int cardNumber) {
        super(description, chanceKort);
        this.cardNumber = cardNumber;
    }
}
