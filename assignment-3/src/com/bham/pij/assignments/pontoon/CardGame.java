package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;

// Martin de Spirlet 1785605

/**
 * CardGame
 *
 * @author Martin de Spirlet
 */
public abstract class CardGame {

    private Deck deck = new Deck();
    private ArrayList<Player> players = new ArrayList<>();

    public CardGame(int nplayers) {
        for (int i = 1; i <= nplayers; ++i) {
            players.add(new Player("Player " + i));
        }
    }

    /**
     * Deals the number of initial cards to each player in the game.
     */
    public abstract void dealInitialCards();

    /**
     * Compares the hands of two players. If `hand1` is better than `hand2`, this
     * method returns -1. If `hand2` is better than `hand1`, this method returns 1.
     * If the two hands are equal, this method returns 0.
     *
     * @param hand1 the first player.
     * @param hand2 the second player.
     * @return -1 if `hand1` is better than `hand2`, 1 if `hand2` is better than
     *         `hand1`, or 0 if the two hands are equal.
     */
    public abstract int compareHands(Player hand1, Player hand2);

    /**
     * Returns the deck.
     *
     * @return the deck.
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Returns the player at the specified index.
     *
     * @param i the index of the player to return.
     * @return the player at the specified index, or `null` if the index is out of
     *         range.
     */
    public Player getPlayer(int i) {
        if (i < 0 || i >= players.size()) {
            return null;
        } else {
            return players.get(i);
        }
    }

    /**
     * Returns the number of players in the game.
     *
     * @return the number of players in the game.
     */
    public int getNumPlayers() {
        return players.size();
    }

}
