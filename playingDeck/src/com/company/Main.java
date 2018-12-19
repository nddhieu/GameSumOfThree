/**
 * author Hieu Nguyen
 * version 1.0.0 12.19.18
 * this game is play ing game sum of three card.
 * input number of player and user name
 * the game create a deck 52 cards, shufle the deck, and divide to each player 3 cards
 * then the app will calculate the sum of card in each player ( jack, queen and king are count as 0)
 * the player has highest sum of card (0-9) will win (not counting the ten decimal: ex : value 14, 24 is equal to 4)
 */
package com.company;

import com.company.deck.Deck;
import com.company.player.Player;
import com.company.player.PlayerCard;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int numberOfPlayer;
        String userName;
        final int NUMBEROFPLAYCARD = 3;
        Scanner scanner = new Scanner(System.in);
        Player playerList = new Player();

        System.out.println("PLAYING GAME SUM OF THREE CARD");
        Deck deck1 = setUpDeck();

        numberOfPlayer = getNumberOfPlayer();

        userName = getUserName(scanner);

        addPlayerToGame(numberOfPlayer, userName, playerList);

        // duel deck to each player
        System.out.println("duel deck ...");
        deck1.duelDeck(deck1, NUMBEROFPLAYCARD, playerList);

        // print player card
        printPlayerCard(playerList);

        SumOfThreeGame game = new SumOfThreeGame();
        ArrayList<Integer> score = new ArrayList<Integer>(); // index of score is the same as index of player, so that we can figure out the player name

        SumOfThreeGame.calculateScore(playerList, game, score);
        int highestScore = highestScore(score);
        printWinner(playerList, highestScore, score);


    }

    public static void printWinner(Player playerList, int highestScore, ArrayList<Integer> score) {
        for (int i = 0; i < playerList.Player.size(); i++) {
            if (score.get(i).intValue() == highestScore) {
                System.out.println("winner is " + playerList.Player.get(i).getName());
            }
        }
    }

    public static int highestScore(ArrayList<Integer> score) {
        int max = score.get(0);
        for (int i : score) {
            if (i >= max) {
                max = i;
            }
        }
        return max;
    }

    private static String getUserName(Scanner scanner) {
        String userName;
        System.out.println("what is your name");
        userName = scanner.nextLine();
        return userName;
    }

    private static void addPlayerToGame(int numberOfPlayer, String userName, Player playerList) {
        playerList.Player.add(new PlayerCard(userName));
        for (int i = 2; i <= numberOfPlayer; i++) {
            playerList.Player.add(new PlayerCard("player " + i));
        }
    }

    private static void printPlayerCard(Player playerList) {
        for (int i = 0; i < playerList.Player.size(); i++) {
            System.out.print("\n" + playerList.Player.get(i).getName() + " play card : \t");
            playerList.Player.get(i).printPlayerCard(playerList.Player.get(i));
        }
    }

    private static int getNumberOfPlayer() {
        int numberOfPlayer = 0;
        Scanner scanner = new Scanner(System.in);
        Boolean validInput;
        do {
            validInput = true;
            System.out.println("how many player want to play");
            try {
                String readInput = scanner.nextLine();
                numberOfPlayer = Integer.parseInt(readInput);
            } catch (Exception e) {
                System.out.println("pleas input a valid number");
                validInput = false;
            }
        }
        while (!validInput && numberOfPlayer == 0);
        return numberOfPlayer;
    }

    private static Deck setUpDeck() {
        Deck deck1 = new Deck();
        System.out.println("create Deck ...");
        deck1.createDeck();
        //deck1.printDeck(deck1);
        System.out.println("shuffle deck ...");
        deck1.shuffleDeck(deck1);
        //deck1.printDeck(deck1);
        return deck1;
    }
}
