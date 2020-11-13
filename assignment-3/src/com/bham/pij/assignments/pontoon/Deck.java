package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.bham.pij.assignments.pontoon.Card.Suit;
import com.bham.pij.assignments.pontoon.Card.Value;

// Martin de Spirlet 1785605

/**
 * Deck
 *
 * @author Martin de Spirlet
 */
public class Deck {

    private static Random random = new Random();
    private ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        reset();
    }

    /**
     * Resets the deck to a full set of 52 distinct cards. These are the 13 cards of
     * each suit. There are no repeated cards in the deck.
     */
    public void reset() {
        cards.clear();

        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                cards.add(new Card(suit, value));
            }
        }
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Returns the card at the specified index of the deck.
     *
     * @param i the index of the card.
     * @return the card at the specified index of the deck, or `null` if the index
     *         is out of range.
     */
    public Card getCard(int i) {
        if (i < 0 || i >= cards.size()) {
            return null;
        } else {
            return cards.get(i);
        }
    }

    /**
     * Removes and returns a card at random from the deck.
     *
     * @return a card at random from the deck, or `null` if the deck is empty.
     */
    public Card dealRandomCard() {
        if (cards.isEmpty()) {
            return null;
        } else {
            return cards.remove(random.nextInt(cards.size()));
        }
    }

    /**
     * Returns the number of cards in the deck.
     *
     * @return the number of cards in the deck.
     */
    public int size() {
        return cards.size();
    }

}
