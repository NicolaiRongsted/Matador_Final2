package org.example;

import java.io.*;

public class SaveGame implements Serializable {
    private int currentPlayer = 0;
    private int[] playerMoney;
    private int[] player1Properties;
    private int[] player2Properties;
    private int[] player3Properties;
    private int[] player4Properties;
    private int[] propertyPrice;
    private int[] propertyRent;
    private int[] propertyOwner;
    private boolean[] propertyMortgaged;
    private boolean[] playerAI;
    private int[] playerPosition;
    private boolean[] playersInJail;

    public void saveGame(){
        try{
            FileOutputStream fileOut = new FileOutputStream("game.sav");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getPlayerMoney(int player) {
        return playerMoney[player];
    }

    public void setPlayerMoney(int player, int money) {
        this.playerMoney[player] = money;
    }

    public void setPlayersInJail(int player, boolean inJail){
        this.playersInJail[player] = inJail;
    }
    public void setPlayerPosition(int player, int position){
        this.playerPosition[player] = position;
    }
    public int[] getPlayerPosition(){
        return playerPosition;
    }
    public void setPropertyOwner(int property, int player){
        this.propertyOwner[property] = player;
    }
    public void setPlayerProperties(int[] player1Properties, int[] player2Properties, int[] player3Properties, int[] player4Properties){
        this.player1Properties = player1Properties;
        this.player2Properties = player2Properties;
        this.player3Properties = player3Properties;
        this.player4Properties = player4Properties;
    }
    public int[] getPlayerProperties(int player){
        if (player == 0){
            return player1Properties;
        }else if (player == 1){
            return player2Properties;
        }else if (player == 2){
            return player3Properties;
        }else {
            return player4Properties;
        }
    }
    public void setPlayerOrAi(int i, boolean ai) {
        this.playerAI[i] = ai;
    }

    public boolean[] getPlayerAI(){
        return playerAI;
    }



    // similar getters and setters for other member variables
}