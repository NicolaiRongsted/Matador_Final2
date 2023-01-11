package org.example;

public class GamestateLoader {
    private static Gamestate[] gamestates = {
            new Gamestate(3,true, false, new int[]{3, 3}, false,0, false), //
            new Gamestate(4, true, false, new int[]{10}, true, 20, false), //
            new Gamestate(5, true, false, new int[]{7,7}, false, 0, false), //
            new Gamestate(6, true, false, new int[]{11}, true, 32, false), //
            new Gamestate(7, true,false, new int[]{4,4}, true, 0, false), //
            new Gamestate(8, false, true, new int[]{10}, false, 0, false ), //Slaa 2 ens
            new Gamestate(9, false, true, new int[]{10}, true, 20, true) //2 ens uid af faengsel
            //new Gamestate(10), //

    };
    public static Gamestate[] getGamestates(){
        return gamestates;
    }
}
