package org.example;

public class GamestateLoader {
    private static Gamestate[] gamestates = {
            new Gamestate(3,true, false, new int[]{3, 3}, false,0), //
            new Gamestate(4, true, false, new int[]{10}, true, 20), //
            new Gamestate(5, true, false, new int[]{7,7}, false, 0), //
            new Gamestate(6, true, false, new int[]{11}, true, 32), //
            new Gamestate(7, true,false, new int[]{3}, true, 39), //
            new Gamestate(8, false, true, new int[]{0}, false, 0), //
            //new Gamestate(9), //
            //new Gamestate(10), //

    };
    public static Gamestate[] getGamestates(){
        return gamestates;
    }
}
