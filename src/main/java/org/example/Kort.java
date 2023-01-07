package org.example;
enum KortType {
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


