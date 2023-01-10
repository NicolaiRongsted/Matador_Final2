package org.example;

public class GamestateLoader {
    private static Gamestate[] gamestates = {
            new Gamestate(3, new int[]{3, 3}), //
            //new Gamestate(4), //
            //new Gamestate(5), //
            //new Gamestate(6), //
            //new Gamestate(7), //
            //new Gamestate(8), //
            //new Gamestate(9), //
            //new Gamestate(10), //

    };
    public static Gamestate[] getGamestates(){
        return gamestates;
    }
}
