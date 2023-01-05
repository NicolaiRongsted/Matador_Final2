package org.example;
import java.util.Scanner;

import gui_codebehind.GUI_BoardController;
import gui_fields.GUI_Board;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import gui_codebehind.GUI_FieldFactory;
import gui_codebehind.GUI_Center;


public class Main {
    public static void main(String[] args) {
        int playeramount;
        GUI gui = new GUI();
        String chosenButton = gui.getUserButtonPressed(
                "Choose number of players",
                "2 players", "3 players", "4 players"
        );
        if (chosenButton == ("2 players")){
            playeramount = 2;
        }
        else if (chosenButton == ("3 players")){
            playeramount = 3;
        }
        else{
            playeramount = 4;
        }
        Player[] players = new Player[playeramount];
        GUI_Player[] GUIplayers = new GUI_Player[playeramount];
        for (int i = 0; i < playeramount; i++){
            GUIplayers[i] = new GUI_Player("Spiller " + i, 20);
            gui.addPlayer(GUIplayers[i]);
        }
        bræt Bræt = new bræt();
        Bræt.Board();
        /*while ((player1.getBalance()) > 0) {

            String chosen1Button = gui.getUserButtonPressed(
                    "Roll a dice",
                    "Roll dice"
            );

            terning1.roll();
            gui.setDie(terning1.getFaceValue());
            Playerlocation1 = Playerlocation1 += terning1.getFaceValue();

            //PLAYER 1
            if (Playerlocation1 >= 40) {
                Playerlocation1 = Playerlocation1 % 40;
                PlayerBalance1 += 2;
                player1.setBalance(PlayerBalance1);

            }
            GUI_Field field1 = gui.getFields()[Playerlocation1];
            player1.getCar().setPosition(field1);

            String chosen2Button = gui.getUserButtonPressed(
                    "Roll a dice",
                    "Roll dice"
            );

            terning2.roll();
            gui.setDie(terning2.getFaceValue());
            Playerlocation2 = Playerlocation2 += terning2.getFaceValue();
            if (Playerlocation2 >= 40) {
                Playerlocation2 = Playerlocation2 % 40;
                PlayerBalance2 += 2;
                player2.setBalance(PlayerBalance2);
            }
            GUI_Field field2 = gui.getFields()[Playerlocation2];
            player2.getCar().setPosition(field2);

            String chosen3Button = gui.getUserButtonPressed(
                    "Roll a dice",
                    "Roll dice"
            );

            terning3.roll();
            gui.setDie(terning3.getFaceValue());
            Playerlocation3 = Playerlocation3 += terning3.getFaceValue();
            if (Playerlocation3 >= 40) {
                Playerlocation3 = Playerlocation3 % 40;
                PlayerBalance3 += 2;
                player3.setBalance(PlayerBalance3);
            }
            GUI_Field field3 = gui.getFields()[Playerlocation3];
            player3.getCar().setPosition(field3);


            String chosen4Button = gui.getUserButtonPressed(
                    "Roll a dice",
                    "Roll dice"
            );


            terning4.roll();
            gui.setDie(terning4.getFaceValue());
            Playerlocation4 = Playerlocation4 += terning4.getFaceValue();
            if (Playerlocation4 >= 40) {
                Playerlocation4 = Playerlocation4 % 40;
                PlayerBalance4 += 2;
                player4.setBalance(PlayerBalance4);
            }
            GUI_Field field4 = gui.getFields()[Playerlocation4];
            player4.getCar().setPosition(field4);



        }
        */

    }
}