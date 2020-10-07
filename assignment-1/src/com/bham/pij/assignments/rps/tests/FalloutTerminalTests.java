package com.bham.pij.assignments.rps.tests;

import com.bham.pij.assignments.rps.FalloutTerminal;

public class FalloutTerminalTests {

    private static FalloutTerminal ft = new FalloutTerminal();

    public static void main(String[] args) {
        System.out.println("Test 1: " + resultAsString(test1()));
        System.out.println("Test 2: " + resultAsString(test2()));
        System.out.println("Test 3: " + resultAsString(test3()));
        System.out.println("Test 4: " + "Test not written.");
    }

    public static String resultAsString(boolean result) {
        return result ? "Pass" : "Fail";
    }

    /**
     * This test checks that your buildDisplayLine() method returns a string of the
     * correct length.
     */
    public static boolean test1() {
        int correctLength = (6 + 1 + 30) + 1 + (6 + 1 + 30);

        return (ft.buildDisplayLine(0x9380, 0.7f).length() == correctLength)
                && (ft.buildDisplayLine(0xB720, 0.5f).length() == correctLength);
    }

    /**
     * This test checks that your buildDisplayLine() method returns a string
     * containing the correct addresses.
     */
    public static boolean test2() {
        String displayLine = ft.buildDisplayLine(0x9380, 0.6f);

        return displayLine.contains("0x9380") && displayLine.contains("0x9470");
    }

    /**
     * This test checks that your buildDisplayLine() method returns a string
     * containing random characters.
     */
    public static boolean test3() {
        String displayLine = ft.buildDisplayLine(0x9380, 0.7f);

        for (char c : displayLine.substring(7, 38).toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * This test checks that your buildDisplayLine() method returns a string
     * containing random characters
     */
    public static boolean test4() {
        return false;
    }

}
