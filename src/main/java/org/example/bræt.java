package org.example;

import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class bræt {

        public void Board () {

        GUI_Field[] fields = new GUI_Field[24];

        fields[0] = new GUI_Start("Start", "", "Her starter du", Color.ORANGE, Color.WHITE);
        fields[1] = new GUI_Street("Burgerbaren", "Pris: 1M", "Det her en vej", "1", Color.ORANGE, Color.WHITE);
        fields[2] = new GUI_Street("Pizzahuset", "Pris: 1M", "Det her er en vej", "1", Color.ORANGE, Color.WHITE);
        fields[3] = new GUI_Chance("?", "", "Prøv lykken", Color.yellow, Color.WHITE);
        fields[4] = new GUI_Street("Slikbutikken", "Pris: 1M", "Det her en vej", "1", Color.ORANGE, Color.WHITE);
        fields[5] = new GUI_Street("Iskiosken", "Pris: 1M", "Det her en vej", "1", Color.ORANGE, Color.WHITE);
        fields[6] = new GUI_Jail("", "Fængsel", "FÆNGSEL", "Du røg i fængsel", Color.BLACK, Color.WHITE);
        fields[7] = new GUI_Street("Museet", "Pris: 2M", "Det her en vej", "2", Color.ORANGE, Color.WHITE);
        fields[8] = new GUI_Street("Biblioteket", "Pris: 2M", "Det her en vej", "2", Color.ORANGE, Color.WHITE);
        fields[9] = new GUI_Chance("?", "", "Prøv lykken", Color.yellow, Color.WHITE);
        fields[10] = new GUI_Street("Skaterparken", "Pris: 2M", "Det her en vej", "2", Color.ORANGE, Color.WHITE);
        fields[11] = new GUI_Street("Swimmingpoolen", "Pris: 2M", "Det her en vej", "2", Color.ORANGE, Color.WHITE);
        fields[12] = new GUI_Street("Parkering", "Pris: 0", "Gratis Parkering", "0", Color.WHITE, Color.BLACK);
        fields[13] = new GUI_Street("Spillehallen", "Pris: 3M", "Det her en vej", "3", Color.ORANGE, Color.WHITE);
        fields[14] = new GUI_Street("Biograf", "Pris: 3M", "Det her en vej", "3", Color.ORANGE, Color.WHITE);
        fields[15] = new GUI_Chance("?", "", "Prøv lykken", Color.yellow, Color.WHITE);
        fields[16] = new GUI_Street("Legetøjsbutikken", "Pris: 3M", "Det her en vej", "3", Color.ORANGE, Color.WHITE);
        fields[17] = new GUI_Street("Dyrehandlen", "Pris: 3M", "Det her en vej", "3", Color.ORANGE, Color.WHITE);
        fields[18] = new GUI_Jail("", "Fængsel", "FÆNGSEL", "Du røg i fængsel", Color.BLACK, Color.WHITE);
        fields[19] = new GUI_Street("Bowlinghallen", "Pris: 4M", "Det her en vej", "4", Color.ORANGE, Color.WHITE);
        fields[20] = new GUI_Street("Zoologisk have", "Pris: 4M", "Det her en vej", "4", Color.ORANGE, Color.WHITE);
        fields[21] = new GUI_Chance("?", "", "Prøv lykken", Color.yellow, Color.WHITE);
        fields[22] = new GUI_Street("Vandlandet", "Pris: 5M", "Det her en vej", "5", Color.ORANGE, Color.WHITE);
        fields[23] = new GUI_Street("Strandpromenaden", "Pris: 5M", "Det her en vej", "5", Color.ORANGE, Color.WHITE);


        GUI gui = new GUI(fields);


        }
    }