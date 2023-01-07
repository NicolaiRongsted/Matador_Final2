package org.example;

public class GameController {


    MonopolyGUI game = new MonopolyGUI();
    SpecialFelter chancekort = new SpecialFelter();
    boolean playing = true;

    public void play(){
        game.GUIstartup();
        CreatePlayers();
        PlayRound();
    }
    private void CreatePlayers(){
        game.GUIPlayerstart();
    }


    private void PlayRound(){

        while (playing) {


            //skal bestemme hvilken spillers tur det er

            //Tjekke om spiller er i fængsel (bedre at gøre der hvor man ruller og hvis man skal rykke)

            //Hvis spiller er i fængsel Slå 2 ens eller betale og miste tur(Igen bedre i der hvor man opdaterer positionen eller i en seperat funktion, men ikke her.)

            //skal bede en spiller om at slå
            game.showMessage("Slå med terningerne");
            //skal slå med terninger
            game.roll();
            //skal vise hvad man slog (At vise hvad der bliver slået er nok også bedst at gøre i roll.)
            game.getFace();

            int sum = game.terning1.getFaceValue() + game.terning2.getFaceValue();

            Kort feltLandedOn = handleDiceValue(sum);

            //handleGui(feltLandedOn); Håndter GUI, så hvis feltLandedOn = 4,
            //handleCardLogic(feltLandedOn, Player()); her skal specifik spiller indsættes





            //Skal rykke på spilleren?

            //Over start modtage penge opdatere balance

            //Indkomstskat betale bede spiller om at vælge betale 10% eller 200 og opdatere balance

            //Hvis fængsel låse spiller indtil ude

            //Hvis u-købt felt bede spiller om at købe og opdatere balance

            //Hvis købt felt betale leje og opdatere balance

            //Hvis chance felt trække kort
            //Udføre chancekort

            //skal gå videre til næste spiller
            game.showMessage("Næste spillers tur");

            //
        }

    }

    private void moveToField(){



    }

    private void handleCardLogic(Kort kort, Player player){

        switch (kort.type) {
            //Start
            case ChanceKort -> {
                var chanceKort = (ChanceKort) kort;
                handleChanceKort(chanceKort.cardNumber, player);
            }

            //Chancekort
            case TredjeKort -> {

            }
            default -> {

            }
        }

    }

    private void handleChanceKort(int cardNumber, Player player) {
        switch (cardNumber){
            case 1 -> {
                player.setPosition(5); // her skal kort logik udføres
            }
        }
    }

    private Kort handleDiceValue(int value){

        switch (value) {
            //Start
            case 0 -> System.out.println("Lav start logik");

            //Chancekort
            case 2, 7, 17, 22, 33, 36 -> {
                return chancekort.getChancekort();
            }
            default -> {
                //Slet ret
                return new ChanceKort("test", KortType.Egendom);
            }
        }
        //Slet ret
        return new ChanceKort("test", KortType.Egendom);
    }


}
