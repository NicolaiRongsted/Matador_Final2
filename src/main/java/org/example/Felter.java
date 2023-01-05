package org.example;

public class Felter {

    String FeltNavn;
    int FeltVaerdi;
    int FeltNummer;

    Terning terning = new Terning();

    public Felter(String feltNavn, int feltVaerdi, int feltNummer)  {
        FeltNavn = feltNavn;
        FeltVaerdi = feltVaerdi;
        FeltNummer = feltNummer;
    }

    public String getFeltNavn(){
        return FeltNavn;
    }

    public int getFeltVaerdi(){
        return FeltVaerdi;
    }

    public int getFeltNummer(){
        return FeltNummer;
    }


}
