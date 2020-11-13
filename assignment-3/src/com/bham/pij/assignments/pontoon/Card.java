package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;
import java.util.Arrays;

// Martin de Spirlet 1785605

/**
 * Card
 *
 * @author Martin de Spirlet
 */
public class Card {

    public static enum Suit {
        CLUBS, HEARTS, DIAMONDS, SPADES
    }

    public static enum Value {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * Returns the suit of the card.
     *
     * @return the suit of the card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Sets the suit of the card.
     *
     * @param suit the suit to set.
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * Returns the value of the card.
     *
     * @return the value of the card.
     */
    public Value getValue() {
        return value;
    }

    /**
     * Sets the value of the card.
     *
     * @param value the value to set.
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * Returns the list of numerical values represented by the card, in ascending
     * order. For a card with the value `ACE`, the list contains 1 and 11. All other
     * cards represent one numerical value. If the card value is invalid, the
     * returned list contains only 0.
     *
     * @return the list of numerical values represented by the card.
     */
    public ArrayList<Integer> getNumericalValue() {
        switch (value) {
            case ACE:
                return new ArrayList<>(Arrays.asList(1, 11));
            case TWO:
                return new ArrayList<>(Arrays.asList(2));
            case THREE:
                return new ArrayList<>(Arrays.asList(3));
            case FOUR:
                return new ArrayList<>(Arrays.asList(4));
            case FIVE:
                return new ArrayList<>(Arrays.asList(5));
            case SIX:
                return new ArrayList<>(Arrays.asList(6));
            case SEVEN:
                return new ArrayList<>(Arrays.asList(7));
            case EIGHT:
                return new ArrayList<>(Arrays.asList(8));
            case NINE:
                return new ArrayList<>(Arrays.asList(9));
            case TEN:
                return new ArrayList<>(Arrays.asList(10));
            case JACK:
                return new ArrayList<>(Arrays.asList(10));
            case QUEEN:
                return new ArrayList<>(Arrays.asList(10));
            case KING:
                return new ArrayList<>(Arrays.asList(10));
            default:
                return new ArrayList<>(Arrays.asList(0));
        }
    }

}
