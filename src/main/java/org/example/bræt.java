package org.example;
import gui_fields.*;
import gui_main.GUI;

public class bræt {
    Felter felter[] = {
            new Felter("Rødovrevej", "Blå",1200, 1000, 50,250,750,2250,4000, 6000, 1),
            new Felter("Hvidovrevej", "Blå",1200, 1000, 50,250,750,2250,4000, 6000, 3),
            //færge new Felter("Rødovrevej", "Blå",1200, 1000, 50,250,750,2250,4000, 5), //færge
            new Felter("Roskildevej", "Orange",2000, 1000, 100,600,1800,5400,8000, 11000, 6),
            new Felter("Valby Langgade", "Orange",2000, 1000, 100,600,1800,5400,8000, 11000, 8),
            new Felter("Allegade", "Orange",2400, 1000, 150,600,1800,6000,9000, 12000, 9),
            new Felter("Frederiksberg alle", "Grøn",2800, 2000, 200,1000,3000,9000,12500, 15000, 11),
            new Felter("Bulowsvej", "Grøn",2800, 2000, 200,1000,3000,9000,12500, 15000, 13),
            new Felter("Gl kongevej", "Grøn",3200, 2000, 250,1250,3750,10000,14000, 18000, 14),
            new Felter("Bernstorffsvej", "Grå",3600, 2000, 300,1400,4000,11000,15000, 19000,16),
            new Felter("Hellerupvej", "Grå",3600, 2000, 300,1400,4000,11000,15000, 19000, 18),
            new Felter("Strandvejen", "Grå",4000, 2000, 350,1600,4400,12000,16000, 20000, 19),
            new Felter("Trianglen", "Rød",4400, 3000, 350,1800,5000,14000,17500, 21000, 21),
            new Felter("Rødovrevej", "Blå",1200, 1000, 50,250,750,2250,4000, 1),
            new Felter("Rødovrevej", "Blå",1200, 1000, 50,250,750,2250,4000, 1),
            new Felter("Rødovrevej", "Blå",1200, 1000, 50,250,750,2250,4000, 1),
            new Felter("Rødovrevej", "Blå",1200, 1000, 50,250,750,2250,4000, 1),


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


     public static String[] getPris(){
        return Pris;
     }
     public static int[] felt(){
        return felt;
     }
    }