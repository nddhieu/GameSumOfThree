package com.company.player;

import java.util.ArrayList;

public class Player {
    public ArrayList<PlayerCard> Player = new ArrayList<>();
    int valueOfGame;

    public int getValueOfGame() {
        return valueOfGame;
    }

    public void setValueOfGame(int valueOfGame) {
        this.valueOfGame = valueOfGame;
    }
}
