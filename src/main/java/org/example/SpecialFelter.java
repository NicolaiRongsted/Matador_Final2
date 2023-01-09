package org.example;


import java.util.Random;

public class SpecialFelter {

    public SpecialFelter(){

    }
    ChanceKort chanceKort[] = { //Alle vores chancekort minus et par da de tager for lang tid at kode til vores MVP
            //new ChanceKort("Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel", KortType.ChanceKort, 1, +2000),
            //new ChanceKort("Ejendomsskatten er steget. Ekstraudgifterne er: 800 kr pr hus, 2300 kr pr hotel.", KortType.ChanceKort, 2),
            new ChanceKort("De har kørt frem for “fuldt stop”, Betal 1000 kroner i bøde", KortType.ChanceKort, 1, -1000,0,2),
            new ChanceKort("Betal for vognvask og smøring kr 300", KortType.ChanceKort, 2, -300,0,2),
            new ChanceKort("Betal kr 200 for levering af 2 kasser øl", KortType.ChanceKort, 3, -200,0,2),
            new ChanceKort("Betal 3000 for reparation af deres vogn", KortType.ChanceKort, 4, -3000,0,2),
            new ChanceKort("De har købt 4 nye dæk til Deres vogn, betal kr 1000", KortType.ChanceKort, 5, -1000,0,2),
            new ChanceKort("De har fået en parkeringsbøde, betal kr 200 i bøde", KortType.ChanceKort, 6, -200,0,2),
            new ChanceKort("Betal deres bilforsikring, kr 1000", KortType.ChanceKort, 7, -1000,0,2),
            new ChanceKort("De har været udenlands og købt for mange smøger, betal kr 200 i told.", KortType.ChanceKort, 8, -200,0,2),
            new ChanceKort("Tandlægeregning, betal kr 2000.", KortType.ChanceKort, 9, -2000,0,2),
            new ChanceKort("De har vundet i klasselotteriet. Modtag 500 kr.", KortType.ChanceKort, 10,+500,0,2),
            new ChanceKort("De modtager Deres aktieudbytte. Modtag kr 1000 af banken", KortType.ChanceKort, 11, +1000,0,2),
            new ChanceKort("Kommunen har eftergivet et kvartals skat. Hæv i banken 3000 kr.", KortType.ChanceKort, 12, +3000,0,2),
            new ChanceKort("De have en række med elleve rigtige i tipning, modtag kr 1000", KortType.ChanceKort, 13, +1000,0,2),
            new ChanceKort("Grundet dyrtiden har De fået gageforhøjelse, modtag kr 1000.", KortType.ChanceKort, 14, +1000,0,2),
            new ChanceKort("Deres præmieobligation er udtrykket. De modtager 1000 kr af banken.", KortType.ChanceKort, 15, +1000,0,2),
            new ChanceKort("De har solgt nogle gamle møbler på auktion. Modtag 1000 kr af banken.", KortType.ChanceKort, 16, +1000,0,2),
            new ChanceKort("Værdien af egen avl fra nyttehaven udgør 200 som de modtager af banken", KortType.ChanceKort, 17, +200,0,2),
            //new ChanceKort("De modtager “Matador-legatet” på kr 40.000, men kun hvis værdier ikke overstiger 15.000 kr", KortType.ChanceKort, 20),
            //new ChanceKort("Det er deres fødselsdag. Modtag af hver medspiller 200 kr.", KortType.ChanceKort, 21, +200),
            //new ChanceKort("De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr.", KortType.ChanceKort, 22,),
            //new ChanceKort("De skal holde familiefest og får et tilskud fra hver medspiller på 500 kr.", KortType.ChanceKort, 23),
            new ChanceKort("Ryk frem til START", KortType.ChanceKort, 18, 0,0,1),
            new ChanceKort("Ryk tre felter frem", KortType.ChanceKort, 19, 0,+3,1),
            new ChanceKort("Ryk tre felter tilbage", KortType.ChanceKort, 20, 0,-3,1),
            new ChanceKort("Ryk frem til Frederiksberg Allé. Hvis De passere START, indkasser da 4000 kr.", KortType.ChanceKort, 21, 0,11,1),
            //new ChanceKort("Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til, hvis selskabet ikke ejes af nogen kan De købe det af banken.", KortType.ChanceKort, 28),
            new ChanceKort("Tag med Mols-Linien, flyt brikken frem og hvis De passerer START indkassér da kr 4000.", KortType.ChanceKort, 22,0,16,1),
            new ChanceKort("Ryk frem til Grønningen, hvis De passerer start indkasser da kr 4000", KortType.ChanceKort, 23,0,24,1),
            new ChanceKort("Ryk frem til Vimmelskaftet, hvis de passerer start indkasser da kr 4000", KortType.ChanceKort, 24,0,32,1),
            //new ChanceKort("Tag med den nærmeste færge, hvis de passerer start indkasser da kr 4000", KortType.ChanceKort, 25,0),
            new ChanceKort("Ryk frem til Strandvejen. Hvis De passere START, indkasser da 4000 kr.", KortType.ChanceKort, 25,0,19,1),
            new ChanceKort("Tag til Rådhuspladsen", KortType.ChanceKort, 26,0,39,1),
            //new ChanceKort("Gå i fængsel, De indkasserer ikke 4000 kr for at passere start.", KortType.ChanceKort, 35),
            //new ChanceKort("I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det, eller De kan sælge det. (antal kort: 2)", KortType.ChanceKort, 36),




    };

    public int getChancekort() { //getChancekort giver os et random kort fra vores 27 mulige kort
        int antalKort = 26;
        int randomValue = (int)(Math.random() * antalKort) + 1;

        return randomValue;
    }
    public int getCardValue(int Kort) { //getCardValue giver os den "værdi chancekortet har hvis den skal opdatere balancen på spilleren
        int cardValue = chanceKort[Kort].cardValue;

        return cardValue;
    }
    public int getCardPositon(int Kort) { //getCardPosition er til hvilken position man rykker til i gui'en hvis man trækker et chancekort der f.eks. er ryk til rådhuspladsen
        int cardPosition = chanceKort[Kort].cardPosition;

        return cardPosition;
    }
    public int getCaseNumber (int Kort) { //getCardPosition er til hvilken position man rykker til i gui'en hvis man trækker et chancekort der f.eks. er ryk til rådhuspladsen
        int caseNumber = chanceKort[Kort].caseNumber;

        return caseNumber;
    }
    public String getDescription (int Kort) { //getCardPosition er til hvilken position man rykker til i gui'en hvis man trækker et chancekort der f.eks. er ryk til rådhuspladsen
         String description = chanceKort[Kort].description;

        return description;
    }
}


