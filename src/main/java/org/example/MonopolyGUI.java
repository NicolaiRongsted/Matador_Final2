package org.example;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class MonopolyGUI {
    Terning terning1 = new Terning();
    Terning terning2 = new Terning();
    public static GUI gui = new GUI();
    static GUI_Player[] player = new GUI_Player[4];
    GUI_Field start = gui.getFields()[0];
    public GUI GUIstartup(){
        return gui;
    }
    public void GUIPlayerstart(){
        bræt.Board();
        String playeramountstring = gui.getUserSelection("How many players?", "2", "3", "4");
        int playeramount = Integer.parseInt(playeramountstring);
        for (int i = 1; i < playeramount + 1; i++){
            String playername = gui.getUserString("Whats the name of player " + i + "?");
            player[i - 1] = new GUI_Player(playername, 30000);
            gui.addPlayer(player[i - 1]);
            player[i - 1].getCar().setPosition(start);
        }
    }

    public void Updatebalance(int leje, int id){ // Updatebalance, fungerer på den måde at man sætter to parameter den skal bruge. En leje og id på personen, som er player: 0, 1, 2 ,
                                                            // Koden er derfor lavet på den måde, at man kalder på playerens id, og derfra sætter playerens balance, udfra hvad playerens
        player[id].setBalance(player[id].getBalance()+leje); // balance er i forvejen, og ligger lejen til eller trækker fra, alt afhængig af om det leje man skal betale eller få
    }

    public void Updateposition(int ID){ //Opdater positionen på gui

    }

    public void showMessage(String msg){
        gui.showMessage(msg);

    }

    public void roll(){
        terning1.roll();
        terning2.roll();
    }

    public void getFace(){
        gui.setDice(terning1.getFaceValue(), terning2.getFaceValue());

    }




    public boolean Yes_or_no(String message){
        String yes = "Yes";
        String no = "No";
        String input = gui.getUserSelection(message, yes, no);
        return input.equals(yes);
    }
}
