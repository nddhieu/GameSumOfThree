package com.company.deck;

import com.company.player.Player;
import com.company.player.PlayerCard;

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> Deck1 = new ArrayList<>();
    private Player playerL = new Player();

    public Card getCard(Deck deck, int index) {
        return deck.Deck1.get(index);
    }

    public void createDeck() {

        for (int i = 0; i < 13; i++) {

            for (int j = 1; j <= 4; j++) {
                int index = i * 4 + j;
                switch (j) {
                    case 1:
                        Deck1.add(new Card(i + 1, Type.SPADE));
                        break;
                    case 2:
                        Deck1.add(new Card(i + 1, Type.CLUB));
                        break;
                    case 3:
                        Deck1.add(new Card(i + 1, Type.DIAMOND));
                        break;
                    case 4:
                        Deck1.add(new Card(i + 1, Type.HEART));
                        break;
                }
            }
        }

    }

    public void printDeck(Deck deck) {
        for (Card i : Deck1) {
            System.out.println(i.getCardNumber() + " " + i.getType().toString());
        }
    }

    public void shuffleDeck(Deck deck) {
        int randomIndex1;
        int randomIndex2;
        for (int i = 0; i <= 100; i++) {
            randomIndex1 = (int) (Math.random() * 100) % 52;
            randomIndex2 = (int) (Math.random() * 100) % 52;
            //System.out.println(" random index : " + randomIndex1 + "second index " + randomIndex2);
            switchCard(deck, randomIndex1, randomIndex2);
        }
    }

    private void switchCard(Deck deck, int index1, int index2) {
        Card cardextra = new Card(deck.Deck1.get(index1).getCardNumber(), deck.Deck1.get(index1).getType());

        //print2CardInDeck(deck, index1, index2);

        deck.Deck1.set(index1, Deck1.get(index2));
        deck.Deck1.set(index2, cardextra);

        //print2CardInDeck(deck, index1, index2);

    }

    //this method print card at index of deck, for testing purpose
    private void print2CardInDeck(Deck deck, int index1, int index2) {
        System.out.println("card at " + index1 + " " + getCard(deck, index1).getCardNumber() + " " + getCard(deck, index1).getType() + " " +
                index2 + " " + getCard(deck, index2).getCardNumber() + " " + getCard(deck, index2).getType());
    }

    public Card takeTopCardOutFromDeck(Deck deck) {
        Card card = new Card(deck.Deck1.get(0).getCardNumber(), deck.Deck1.get(0).getType());
//        System.out.println("top card of Deck before remove " + deck.readCard(getCard(deck,0)));

        deck.Deck1.remove(0);
//        System.out.println("top card of Deck after remove " + deck.readCard(getCard(deck,0)));
        return card;
    }

    public String readCard(Card card) {
        return String.format(" " + card.getCardNumber() + " " + card.getType() + " ");
    }

    public void duelDeck(Deck deck, int numberOfCard, Player playerList) {
        boolean doneDuel = false;
        while (!doneDuel) {
            for (PlayerCard p : playerList.Player) {
                p.addPlayerCard(takeTopCardOutFromDeck(deck));
                if (p.numberOfCardPlayerHave() == numberOfCard) {
                    //System.out.println("number of card player have " + p.numberOfCardPlayerHave());
                    doneDuel = true;
                }

            }
        }
    }

}
