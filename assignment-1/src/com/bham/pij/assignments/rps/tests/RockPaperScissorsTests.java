package com.bham.pij.assignments.rps.tests;

import com.bham.pij.assignments.rps.RockPaperScissors;

public class RockPaperScissorsTests {

    private static RockPaperScissors rps = new RockPaperScissors();

    public static void main(String[] args) {
        System.out.println("Test 1: " + resultAsString(test1()));
        System.out.println("Test 2: " + resultAsString(test2()));
        System.out.println("Test 3: " + resultAsString(test3()));
        System.out.println("Test 4: " + resultAsString(test4()));
        System.out.println("Test 5: " + resultAsString(test5()));
        System.out.println("Test 6: " + resultAsString(test6()));
        System.out.println("Test 7: " + resultAsString(test7()));
        System.out.println("Test 8: " + resultAsString(test8()));
        System.out.println("Test 9: " + resultAsString(test9()));
    }

    public static String resultAsString(boolean result) {
        return result ? "Pass" : "Fail";
    }

    /**
     * This test checks only valid inputs to the isValidTurn() method.
     */
    public static boolean test1() {
        return rps.isValidTurn(1) && rps.isValidTurn(2) && rps.isValidTurn(3);
    }

    /**
     * This test checks only invalid inputs to the isValidTurn() method.
     */
    public static boolean test2() {
        return !(rps.isValidTurn(Integer.MIN_VALUE) || rps.isValidTurn(0) || rps.isValidTurn(4)
                || rps.isValidTurn(Integer.MAX_VALUE));
    }

    /**
     * This test checks only invalid inputs to the getPlayerTurn() method.
     */
    public static boolean test3() {
        for (char inputChar = 'A'; inputChar <= 'z'; inputChar++) {
            String inputString = Character.toString(inputChar);

            switch (inputString.toLowerCase()) {
                case "r":
                case "p":
                case "s":
                    break;
                default:
                    if (rps.getPlayerTurn(inputString) != -1) {
                        return false;
                    }
                    break;
            }
        }

        return rps.getPlayerTurn(null) == -1;
    }

    /**
     * This test checks only valid inputs to the getPlayerTurn() method.
     */
    public static boolean test4() {
        return (rps.getPlayerTurn("R") == 1) && (rps.getPlayerTurn("P") == 2) && (rps.getPlayerTurn("S") == 3)
                && (rps.getPlayerTurn("r") == 1) && (rps.getPlayerTurn("p") == 2) && (rps.getPlayerTurn("s") == 3);
    }

    /**
     * This test checks only valid inputs to the getWinner() method with the player
     * as winner.
     */
    public static boolean test5() {
        return rps.getWinner(1, 3).toLowerCase().equals("player") && rps.getWinner(2, 1).toLowerCase().equals("player")
                && rps.getWinner(3, 2).toLowerCase().equals("player");
    }

    /**
     * This test checks only valid inputs to the getWinner() method with the
     * computer as winner.
     */
    public static boolean test6() {
        return rps.getWinner(3, 1).toLowerCase().equals("computer")
                && rps.getWinner(1, 2).toLowerCase().equals("computer")
                && rps.getWinner(2, 3).toLowerCase().equals("computer");
    }

    /**
     * This test checks only valid inputs to the getWinner() method that should
     * result in a draw.
     */
    public static boolean test7() {
        return rps.getWinner(1, 1).toLowerCase().equals("draw") && rps.getWinner(2, 2).toLowerCase().equals("draw")
                && rps.getWinner(3, 3).toLowerCase().equals("draw");
    }

    /**
     * This test checks your getTurnAsString() method returns the correct results
     * for valid values.
     */
    public static boolean test8() {
        return rps.getTurnAsString(1).toLowerCase().equals("rock")
                && rps.getTurnAsString(2).toLowerCase().equals("paper")
                && rps.getTurnAsString(3).toLowerCase().equals("scissors");
    }

    /**
     * This test checks your getTurnAsString() method returns the correct results
     * for invalid values.
     */
    public static boolean test9() {
        return (rps.getTurnAsString(Integer.MIN_VALUE) == null) && (rps.getTurnAsString(0) == null)
                && (rps.getTurnAsString(4) == null) && (rps.getTurnAsString(Integer.MAX_VALUE) == null);
    }

}
