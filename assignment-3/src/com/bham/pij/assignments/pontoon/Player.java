package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

// Martin de Spirlet 1785605

/**
 * Player
 *
 * @author Martin de Spirlet
 */
public class Player {

    private String name;
    private ArrayList<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds the specified card to the player's hand.
     *
     * @param card the card to add.
     */
    public void dealToPlayer(Card card) {
        cards.add(card);
    }

    /**
     * Removes the first occurrence of the specified card from the player's hand.
     *
     * @param card the card to remove.
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
     * Returns the list of all possible numerical values of the player's hand, in
     * ascending order. These are the sums of all possible combinations of the
     * cards, taking one value from each card. For a hand containing at least one
     * card with the value `ACE`, the list contains multiple values. All other hands
     * have one value. An empty hand has a value of 0.
     * <p>
     * This method has been generalised such that it will function correctly even if
     * the enumeration of values of any card are changed.
     *
     * @return the list of all possible numerical values of the player's hand.
     */
    public ArrayList<Integer> getNumericalHandValue() {
        // if there are no cards in the player's hand
        if (cards.isEmpty()) {
            // the hand has a value of 0
            return new ArrayList<>(Arrays.asList(0));
        } else {
            // store cumulative totals
            ArrayList<Integer> handTotals = new ArrayList<>();

            // for each card in the player's hand
            for (Card card : cards) {
                // if no cumulative totals have been stored yet
                if (handTotals.isEmpty()) {
                    // simply append the values of this card to the cumulative totals
                    handTotals.addAll(card.getNumericalValue());
                } else {
                    ArrayList<Integer> cardValues = card.getNumericalValue();
                    int cardValuesSize = cardValues.size();

                    // store initial number of cumulative totals
                    int tempHandTotalsSize = handTotals.size();

                    // for each additional (not first) value (if any)
                    for (int j = 1; j < cardValuesSize; ++j) {
                        // for each initial cumulative total
                        for (int i = 0; i < tempHandTotalsSize; ++i) {
                            // append sum of total and value to cumulative totals
                            handTotals.add(handTotals.get(i) + cardValues.get(j));
                        }
                    }

                    // for each initial cumulative total
                    for (int i = 0; i < tempHandTotalsSize; ++i) {
                        // set total to sum of total and first value
                        handTotals.set(i, handTotals.get(i) + cardValues.get(0));
                    }
                }
            }

            // sort the totals in ascending order
            // (assuming numerical values of each card in the player's hand are sorted in
            // ascending order, the totals should already be in ascending order)
            Collections.sort(handTotals);

            // return `ArrayList` with duplicate values removed (for some reason)
            // (`ArrayList` may not be the most suitable collection for this method)
            // since the stream is ordered, the `distinct()` method will preserve its order
            return handTotals.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        }
    }

    /**
     * Returns the maximum numerical value of the player's hand.
     *
     * @return the maximum numerical value of the player's hand.
     */
    public int getBestNumericalHandValue() {
        return Collections.max(getNumericalHandValue());
    }

    /**
     * Returns the list of cards in the player's hand.
     *
     * @return the list of cards in the player's hand.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Returns the number of cards in the player's hand.
     *
     * @return the number of cards in the player's hand.
     */
    public int getHandSize() {
        return cards.size();
    }

}
