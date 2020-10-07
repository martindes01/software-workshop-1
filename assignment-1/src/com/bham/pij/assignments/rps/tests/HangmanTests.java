package com.bham.pij.assignments.rps.tests;

import com.bham.pij.assignments.rps.Hangman;

public class HangmanTests {

    private static Hangman h = new Hangman(null);

    public static void main(String[] args) {
        System.out.println("Test 1: " + resultAsString(test1()));
        System.out.println("Test 2: " + resultAsString(test2()));
        System.out.println("Test 3: " + resultAsString(test3()));
        System.out.println("Test 4: " + resultAsString(test4()));
        System.out.println("Test 5: " + resultAsString(test5()));
        System.out.println("Test 6: " + resultAsString(test6()));
        System.out.println("Test 7: " + resultAsString(test7()));
    }

    public static String resultAsString(boolean result) {
        return result ? "Pass" : "Fail";
    }

    /**
     * This test checks your targetContains() method with only valid values.
     */
    public static boolean test1() {
        String target = "beatles";

        for (char letter : target.toCharArray()) {
            if (!(h.targetContains(target.toUpperCase(), Character.toUpperCase(letter))
                    && h.targetContains(target.toUpperCase(), Character.toLowerCase(letter))
                    && h.targetContains(target.toLowerCase(), Character.toUpperCase(letter))
                    && h.targetContains(target.toLowerCase(), Character.toLowerCase(letter)))) {
                return false;
            }
        }

        return true;
    }

    /**
     * This test checks your targetContains() method with only invalid values.
     */
    public static boolean test2() {
        String target = "beatles";

        for (char letter = 'A'; letter < 'z'; letter++) {
            switch (Character.toLowerCase(letter)) {
                case 'b':
                case 'e':
                case 'a':
                case 't':
                case 'l':
                case 's':
                    break;
                default:
                    if (h.targetContains(target, letter)) {
                        return false;
                    }
                    break;
            }
        }

        return !h.targetContains(null, 'a');
    }

    /**
     * This test checks your hasFoundCurrent() method correctly identifies when the
     * player has found the target word.
     */
    public static boolean test3() {
        String target = "seven";

        return h.hasFoundTarget(target.toUpperCase(), target.toUpperCase())
                && h.hasFoundTarget(target.toUpperCase(), target.toLowerCase())
                && h.hasFoundTarget(target.toLowerCase(), target.toUpperCase())
                && h.hasFoundTarget(target.toLowerCase(), target.toLowerCase());
    }

    /**
     * This test checks your hasFoundCurrent() method correctly identifies when the
     * player has not found the target word.
     */
    public static boolean test4() {
        String target = "seven";
        String guess = "sewen";

        return !(h.hasFoundTarget(target.toUpperCase(), guess.toUpperCase())
                || h.hasFoundTarget(target.toUpperCase(), guess.toLowerCase())
                || h.hasFoundTarget(target.toLowerCase(), guess.toUpperCase())
                || h.hasFoundTarget(target.toLowerCase(), guess.toLowerCase()));
    }

    /**
     * This test checks your updateCurrentGuess() method correctly updates the guess
     * with a valid letter.
     */
    public static boolean test5() {
        return h.updateCurrentGuess("TEAPOT", "**AP**", 'T').equals("T*AP*T");
    }

    /**
     * This test checks your updateCurrentGuess() method correctly does not update
     * the guess with an invalid letter.
     */
    public static boolean test6() {
        for (char letter = 'A'; letter < 'z'; letter++) {
            switch (Character.toLowerCase(letter)) {
                case 't':
                case 'e':
                case 'a':
                case 'p':
                case 'o':
                    break;
                default:
                    if (!h.updateCurrentGuess("TEAPOT", "**AP**", letter).equals("**AP**")) {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }

    /**
     * This test checks that your getCurrentGuessForDisplay() method returns the
     * correct String.
     */
    public static boolean test7() {
        return h.getCurrentGuessForDisplay("p**g**m").equals("P _ _ G _ _ M");
    }

}
