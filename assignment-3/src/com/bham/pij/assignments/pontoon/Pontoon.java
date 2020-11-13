package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

// Martin de Spirlet 1785605

/**
 * Pontoon
 *
 * @author Martin de Spirlet
 */
public class Pontoon extends CardGame {

    private static final int NUM_INITIAL_CARDS = 2;

    private static final int FIVE_CARD_TRICK_HAND_SIZE = 5;
    private static final int PONTOON_HAND_SIZE = 2;
    private static final int PONTOON_VALUE = 21;

    private static final int RANK_PONTOON = 1;
    private static final int RANK_FIVE_CARD_TRICK = 2;
    private static final int RANK_EQUAL_21 = 3;
    private static final int RANK_LESS_THAN_21 = 4;
    private static final int RANK_BUST = 5;

    public Pontoon(int nplayers) {
        super(nplayers);
    }

    @Override
    public void dealInitialCards() {
        for (int j = 0, nplayers = getNumPlayers(); j < nplayers; ++j) {
            for (int i = 0; i < NUM_INITIAL_CARDS; ++i) {
                getPlayer(j).dealToPlayer(getDeck().dealRandomCard());
            }
        }
    }

    @Override
    public int compareHands(Player hand1, Player hand2) {
        // get ranks of both hands
        int hand1Rank = getHandRank(hand1);
        int hand2Rank = getHandRank(hand2);

        // compare hands by rank
        if (hand1Rank < hand2Rank) {
            // hand1 better than hand2
            return -1;
        } else if (hand2Rank < hand1Rank) {
            // hand2 better than hand1
            return 1;
        } else {
            // both hands have equal rank
            switch (hand1Rank) {
                case RANK_LESS_THAN_21:
                    // both hands have a value less than 21
                    // better hand is that with greatest possible value less than or equal to 21
                    int hand1MaxValidValue = getHandMaxValidValue(hand1);
                    int hand2MaxValidValue = getHandMaxValidValue(hand2);

                    // compare hands by greatest possible value less than or equal to 21
                    if (hand1MaxValidValue > hand2MaxValidValue) {
                        // hand1 better than hand2
                        return -1;
                    } else if (hand2MaxValidValue > hand1MaxValidValue) {
                        // hand2 better than hand1
                        return 1;
                    } else {
                        // both hands equal
                        return 0;
                    }

                case RANK_PONTOON:
                case RANK_FIVE_CARD_TRICK:
                case RANK_EQUAL_21:
                case RANK_BUST:
                default:
                    // all Pontoons are equal
                    // all Five Card Tricks are equal
                    // all hands with a value of 21 are equal
                    // all bust hands are equally worthless
                    // all invalid hand ranks are equally invalid
                    return 0;
            }
        }
    }

    /**
     * Returns the rank of the hand. This is a value corresponding to its
     * classification. A hand with a lower rank has higher precedence. The rank
     * order of all possible hands is as follows.
     * <p>
     * (1) A Pontoon is a hand of two cards with a maximum value of 21.
     * <p>
     * (2) A Five Card Trick is a hand of five cards with a minimum value of less
     * than or equal to 21.
     * <p>
     * (3) A hand of any number of cards with a value of 21 is the next best.
     * <p>
     * (4) A hand of any number of cards with a minimum value of less than 21 is the
     * next best.
     * <p>
     * (5) A hand of any number of cards with a minimum value of greater than 21 is
     * bust (worthless).
     *
     * @param hand the hand whose rank to return.
     * @return the rank of the hand.
     */
    private int getHandRank(Player hand) {
        ArrayList<Integer> handValues = hand.getNumericalHandValue();
        int maxHandValue = hand.getBestNumericalHandValue();
        int minHandValue = handValues.get(0);
        int handSize = hand.getHandSize();

        if ((handSize == PONTOON_HAND_SIZE) && (maxHandValue == PONTOON_VALUE)) {
            // a hand of two cards with a maximum value of 21 is a Pontoon
            return RANK_PONTOON;
        } else if ((handSize == FIVE_CARD_TRICK_HAND_SIZE) && (minHandValue <= PONTOON_VALUE)) {
            // a hand of five cards with a minimum value of less than or equal to 21 is a
            // Five Card Trick
            return RANK_FIVE_CARD_TRICK;
        } else if (handValues.contains(PONTOON_VALUE)) {
            // a hand of any number of cards with a value of 21
            return RANK_EQUAL_21;
        } else if (minHandValue < PONTOON_VALUE) {
            // a hand of any number of cards with a minimum value of less than 21
            return RANK_LESS_THAN_21;
        } else {
            // a hand of any number of cards with a minimum value of greater than 21 is bust
            return RANK_BUST;
        }
    }

    /**
     * Returns the greatest possible value of the specified hand that is less than
     * or equal to 21. This method assumes that the hand contains such a value.
     *
     * @param hand the hand to search.
     * @return the greatest possible value of the specified hand that is less than
     *         or equal to 21.
     * @throws NoSuchElementException if the numerical values of the hand do not
     *                                contain a value less than or equal to 21.
     */
    private int getHandMaxValidValue(Player hand) throws NoSuchElementException {
        return Collections.max(
                hand.getNumericalHandValue().stream().filter(e -> (e <= PONTOON_VALUE)).collect(Collectors.toList()));
    }

}
