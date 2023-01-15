package org.example;
import gui_fields.*;
import gui_main.GUI;

public class bræt {
    static Felter felter[] = {
            new Felter("Start", "null", 0, 0,0,0,0,0,0,0,0),
            new Felter("Rødovrevej", "Blå",1200, 1000, 50,250,750,2250,4000, 6000, 1),
            new Felter("Prv lykken", "Sort", 0,0,0,0,0,0,0,0,0),
            new Felter("Hvidovrevej", "Blå",1200, 1000, 50,250,750,2250,4000, 6000, 3),
            new Felter("Skatte felt", "ingen",0,0,0,0,0,0,0,0,4),
            new Felter("Scandlines", "Faerge",4000, 0, 500,1000,2000,4000,0, 0, 5), //færge
            new Felter("Roskildevej", "Orange",2000, 1000, 100,600,1800,5400,8000, 11000, 6),
            new Felter("Prv lykken", "Sort",0, 0, 0,0,0,0,0, 0, 7),
            new Felter("Valby Langgade", "Orange",2000, 1000, 100,600,1800,5400,8000, 11000, 8),
            new Felter("Allegade", "Orange",2400, 1000, 150,600,1800,6000,9000, 12000, 9),
            new Felter("Faengsel", "Sort",0, 0, 0,0,0,0,0, 0, 10),
            new Felter("Frederiksberg alle", "Grøn",2800, 2000, 200,1000,3000,9000,12500, 15000, 11),
            new Felter("Squash", "Sort",0, 0, 0,0,0,0,0, 0, 12),
            new Felter("Bulowsvej", "Grøn",2800, 2000, 200,1000,3000,9000,12500, 15000, 13),
            new Felter("Gl kongevej", "Grøn",3200, 2000, 250,1250,3750,10000,14000, 18000, 14),
            new Felter("Mols", "Sort",4000, 0, 500,1000,2000,4000,0, 0, 15),
            new Felter("Bernstorffsvej", "Grå",3600, 2000, 300,1400,4000,11000,15000, 19000,16),
            new Felter("Prv lykken", "Sort",0, 0, 0,0,0,0,0, 0, 17),
            new Felter("Hellerupvej", "Grå",3600, 2000, 300,1400,4000,11000,15000, 19000, 18),
            new Felter("Strandvejen", "Grå",4000, 2000, 350,1600,4400,12000,16000, 20000, 19),
            new Felter("Parkering", "Ingen",0, 0, 0,0,0,0,0, 0, 20),
            new Felter("Trianglen", "Rød",4400, 3000, 350,1800,5000,14000,17500, 21000, 21),
            new Felter("Prv lykken", "Sort",0, 0, 0,0,0,0,0, 0, 22),
            new Felter("Østerbrogade", "Rød",4400, 3000, 350,1800,5000,14000,17500, 2100, 23),
            new Felter("Grønningen", "Rød",4800, 3000, 400,2000,6000,15000,18500, 22000, 24),
            new Felter("Scandlines", "Faerge",4000, 0, 500,1000,2000,4000,0, 0, 25),
            new Felter("Bredgade", "Hvid",5200, 3000, 450,2200,6600,16000,19500, 23000, 26),
            new Felter("Kgs. Nytorv", "Hvid",5200, 3000, 450,2200,6600,16000,19500, 23000, 27),
            new Felter("Coca Cola", "Sort",3000, 0, 0,0,0,0,0, 0, 28),
            new Felter("Østergade", "Hvid",5600, 3000, 500,2400,7200,17000,20500, 24000, 29),
            new Felter("De faengsles", "Sort",0, 0, 0,0,0,0,0, 0, 30),
            new Felter("Amagertorv", "Gul",6000, 4000, 550,2600,7800,18000,22000, 25000, 31),
            new Felter("Vimmelskaftet", "Gul",6000, 4000, 550,2600,7800,18000,22000, 25000,32),
            new Felter("Prv lykken", "Sort",0, 0, 0,0,0,0,0, 0, 33),
            new Felter("Nygade", "Gul",6400, 4000, 600,3000,9000,20000,24000, 28000,34),
            new Felter("Scandlines", "Faerge",4000, 0, 500,1000,2000,4000,0, 0, 35),
            new Felter("Prv lykken", "Sort",0, 0, 0,0,0,0,0, 0, 36),
            new Felter("Frederiksberggade", "Lilla",7000, 4000, 700,3500,10000,22000,26000, 30000, 37),
            new Felter("Skat", "Skat",2000, 0, 0,0,0,0,0, 0, 38),
            new Felter("Rådhuspladsen", "Lilla",8000, 4000, 1000,4000,12000,28000,34000, 40000, 39),
    };
    private static String[] Pris = {"1200", "1200", "4000", "2000", "2000", "2400", "2800", "3000", "2800", "3200","4000",
            "3600", "3600", "4000", "4400", "4400", "4800", "4000", "5200", "5200", "3000", "5600", "6000",
            "6000", "6400","4000", "7000", "8000"};
    private static String[] leje = {"50","50","500","100","100","150","200","200","200","250","500","300","300","350","350","350","400","500","450","450","200","500","550","550","600","500","700","1000"};

    private static int[] felt = {1, 3, 5, 6, 8, 9, 11, 12, 13, 14, 15, 16, 18, 19, 21, 23, 24, 25, 26, 27, 28, 29, 31, 32, 34, 35, 37, 39};
    public static void Board () {
            GUI_Field[] fields = MonopolyGUI.gui.getFields();
            for (int i = 0; i < felt.length; i++){
                GUI_Field field = fields[felt[i]];
                field.setSubText(Pris[i]);
                GUI_Ownable ownable = (GUI_Ownable) field;
                ownable.setRent(leje[i]);
            }
     }

     public static int[] getColors(String color){
        String c = color.toLowerCase();
        if(c.equals("blå")){
            return new int[] {1,3};
        } else if (c.equals("orange")) {
            return new int[] {6,8,9};
        } else if (c.equals("grøn")){
            return new int[] {11,13,14};
        } else if (c.equals("grå")){
            return new int[] {16,18,19};
        } else if (c.equals("rød")){
            return new int[] {21,23,24};
        } else if (c.equals("hvid")){
            return new int[] {26,27,29};
        } else if (c.equals("gul")){
            return new int[] {31,32,34};
        } else {
            return new int[] {37,39};
        }
     }

     public static String[] getPris(){
        return Pris;
     }
     public static int[] felt(){
        return felt;
     }
    }