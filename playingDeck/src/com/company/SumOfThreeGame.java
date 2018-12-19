package com.company;

import com.company.player.Player;
import com.company.player.PlayerCard;

import java.util.ArrayList;

public class SumOfThreeGame {
    static void calculateScore(Player playerList, SumOfThreeGame game, ArrayList<Integer> score) {
        System.out.println(); // just to make the print to console readable
        for (int i = 0; i < playerList.Player.size(); i++) {
            score.add(game.sumOfCard(playerList.Player.get(i))); // add score of each player into score List
            System.out.println(playerList.Player.get(i).getName() + " have score " + score.get(i));
        }
    }

    public int valueOfCard(int value) {
        switch (value) {
            case 11:
                return 0;
            case 12:
                return 0;
            case 13:
                return 0;
        }
        return value;
    }

    public int sumOfCard(PlayerCard playerCard) {
        int totalValue = 0;
        for (int i = 0; i < playerCard.numberOfCardPlayerHave(); i++) {
            totalValue = totalValue + valueOfCard(playerCard.getPlayerCard().get(i).getNumber());  // sum up the value of each card in player hand. jack, queen, king are count as 0
        }
        totalValue = totalValue % 10;
        return totalValue;
    }
}
