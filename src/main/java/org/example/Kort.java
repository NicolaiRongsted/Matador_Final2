package org.example;
enum KortType { //Jeg troede originalt at der var fysiske kort i GUI'en til hvert ting altså også skødder men det viser sig kun at være til chancekort
    ChanceKort,
    Egendom,
    TredjeKort
}
public abstract class Kort {
    String description;
    KortType type;




    public Kort(String description, KortType type){
        this.description = description;
        this.type = type;

    }
}


