package com.company.player;

import com.company.deck.Card;

import java.util.ArrayList;

public class PlayerCard {
    String name;
    ArrayList<Card> playerCard = new ArrayList<>();

    public PlayerCard(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlayerCard(Card card) {
//        System.out.println("add Card to player Card " + card.getCardNumber() + " " + card.getType());
        this.playerCard.add(card);
    }

    public void printPlayerCard(PlayerCard playerCard) {
        for (Card c : this.playerCard) {
            System.out.print(" " + c.getCardNumber() + " " + c.getType() + "\t");

        }
    }

    public int numberOfCardPlayerHave() {
//        System.out.println("number of card Player have " + playerCard.size());
        return playerCard.size();
    }

    public ArrayList<Card> getPlayerCard() {
        return playerCard;
    }
}
