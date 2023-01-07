package org.example;
import gui_fields.*;
import gui_main.GUI;

public class bræt {

    public static void Board () {

        String[] Pris = {"1200", "1200", "10% el. 4000", "4000", "2000", "2000", "2400", "2800", "3000", "2800", "3200","4000",
                         "3600", "3600", "4000", "4400", "4400", "4800", "4000", "5200", "5200", "3000", "5600", "6000",
                         "6000", "6400","4000", "7000", "2000", "8000"};

        int[] felt = {1,3,4,5,6,8,9,11,12,13,14,15,16,18,19,21,23,24,25,26,27,28,29,31,32,34,35,37,38,39};

            GUI_Field[] fields = MonopolyGUI.gui.getFields();

            for (int i = 0; i < felt.length; i++){
                GUI_Field field = fields[felt[i]];
                field.setSubText(Pris[i]);
            }
     }
    }