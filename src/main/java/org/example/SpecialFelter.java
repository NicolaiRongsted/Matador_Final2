package org.example;



public class SpecialFelter {

    public SpecialFelter(){

    }
    ChanceKort chanceKort[] = {
            new ChanceKort("Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel", KortType.ChanceKort, 1),
            new ChanceKort("Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel", KortType.ChanceKort, 2),
            new ChanceKort("Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel", KortType.ChanceKort, 3),

    };
    public ChanceKort getChancekort() {
        int antalKort = 10;
        int randomValue = (int)(Math.random() * antalKort) + 1;

        ChanceKort kort = chanceKort[randomValue];

        return  kort;
    }
}


