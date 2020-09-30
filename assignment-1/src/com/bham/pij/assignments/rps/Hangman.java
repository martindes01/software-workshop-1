package com.bham.pij.assignments.rps;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
	/**
	 * This method checks if the parameter 'letter' is contained in the target word represented
	 * by the parameter 'target'. For example, if the target word is BEATLES and the player
	 * has input the letter 'E' then this method should return true. However, if the player has entered
	 * the letter 'K', for example, it should return false.
	 * @param target The target word that the player is trying to guess.
	 * @param letter The letter that has been entered by the player as a guess.
	 * @return true if the letter is in the target, false if not.
	 */
	public boolean targetContains(String target, char letter) {

		/*
		 * Add your code for this method here.
		 */

		return false;
	}

	/**
	 * This method compares the player's current guess to the target String. For example, if the target
	 * word is SEVEN and the player has so far guessed SEVEN then this method should return true.
	 * If the player has guessed any other string of letters then the method should return false.
	 * @param target The target word the player is trying to guess.
	 * @param guess The player's current guess.
	 * @return true if the player's guess matches the target, false if not.
	 */
	public boolean hasFoundTarget(String target, String guess) {

		/*
		 * Add your code for this method here.
		 */

		 return false;
	}

	/**
	 *  This method takes the player's current guess (the whole String) as a parameter and creates a String
	 *  that can be used to display the current state of the guess to the player. This method does NOT display the
	 *  String. The String in the parameter will contain any letters that the player has already guessed correctly
	 *  in their correct positions. For any character position in which the player has not yet guessed
	 *  correctly the input String (currentGuess) will contain an asterisk ('*'). For example, if the target word
	 *  is JAVA, and the player has so far guessed the letter A the String currentGuess will
	 *  be *A*A.
	 *  <br><br>
	 *  The String returned by this method has the following format. It contains the correctly guessed
	 *  letters in the String currentGuess in their correct positions but as upper-case characters (whether or
	 *  not the input was upper case). There will also be a space character between each character and its
	 *  neighbours. Finally, all letters that have NOT been guessed yet will be represented by an underscore ('_').
	 *  For example, if the target word is PROGRAM and the player has so far guessed P, G and M, this method would
	 *  return "P _ _ G_ _ M". There are spaces in this String between the characters but not at the start
	 *  or the end.<br><br>
	 *
	 *  This method assumes that the input guess has at least two characters.
	 * @param currentGuess The player's current guess, in the format described above.
	 * @return The display String, as described above.
	 */
	public String getCurrentGuessForDisplay(String currentGuess) {

		/*
		 * Add your code for this method here.
		 */

		return null;
	}

	/**
	 * This method receives the latest state of the player's guess (as the parameter 'guess'), the
	 * latest character that the player has input ('letter') and the target word ('target'). The method creates a new
	 * String that contains the previous guess but updated with the new letter <em>if</em> that letter
	 * exists in the target.<br><br>
	 *
	 * For example, if the target word is TEAPOT and the player's current guess is **AP** (i.e. they have so far
	 * correctly guessed A and P), and they have now entered the letter T, this method will return the String
	 * T*AP*T.
	 *
	 * @param target The target word.
	 * @param guess The player's current guess.
	 * @param letter The new letter that the player has input.
	 * @return The current guess updated to include the new letter, if it exists in the target.
	 */
	public String updateCurrentGuess(String target, String guess, char letter) {

		/*
		 * Add your code for this method here.
		 */

		return null;
	}


/******************************************************************************
You do not need to look at the code below this point. If you are curious, however, feel
free. Do not change anything below this point though or your own code might not work.
 */
	private static String[] defaultTargets = {
			"beatles",
			"aadvark",
			"compulsory",
			"random",
			"algorithm",
			"chasm",
			"java"
	};

	private static int MAX_GALLOWS = 8;

	private static Random rand;

	private int gallows;

	private static String v;

	private void run() {

		String target = v;

		System.out.println("Enter a guess by pressing a letter key. Type 'quit' to end the game.");

		String display = "";
		String currentGuess = "";

		for (int i = 0; i < target.length(); i++) {
			display += "_ ";
			currentGuess += "*";
		}

		display = display.substring(0,display.length()-1);

		System.out.println(display);

		Scanner in = new Scanner(System.in);

		String input = in.nextLine().toLowerCase();

		boolean gameOver = false;

		while (!input.equals("quit") && !gameOver) {

			if (input.isEmpty() || input.length() > 1) {
				System.out.println("Bad input. Try again.");
				input = in.nextLine();
				continue;
			}

			if (!targetContains(target, input.charAt(0))) {
				System.out.println("The word does not contain the character " + input);
				gallows++;
				System.out.println("Gallows pieces now: " + gallows);
				if (gallows == MAX_GALLOWS) {
					System.out.println("You lost.");
					gameOver = true;
					continue;
				}
			}

			else {
				currentGuess = updateCurrentGuess(target, currentGuess, input.charAt(0));
				display = this.getCurrentGuessForDisplay(currentGuess);
				System.out.println("Current attempt:\n\n" + display);

				if (hasFoundTarget(target, currentGuess)) {
					System.out.println("You won.");
					gameOver = true;
					continue;
				}
			}

			input = in.nextLine();
		}

		in.close();
	}

	public static String v() {return v;}

	public static void main (String[] args) {
		rand = new Random(System.currentTimeMillis());
		String target = defaultTargets[rand.nextInt(defaultTargets.length)];
		Hangman h = new Hangman(target);
		h.run();
	}

	public Hangman(String t) {
		v = t;
	}
}
