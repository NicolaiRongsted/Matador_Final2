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
        GameController game = new GameController();
        game.play();
    }
}