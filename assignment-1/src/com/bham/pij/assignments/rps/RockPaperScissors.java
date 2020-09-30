package com.bham.pij.assignments.rps;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	/**
	 * This method checks that the parameter 'turn' represents a valid turn. A valid turn is
	 * in the range 1 to 3 inclusive. A value of 1 means ROCK; a value of 2 means PAPER and a value of
	 * 3 means SCISSORS. Each turn value is, therefore, represented as an integer. Any value of
	 * 'turn' outside of this range is invalid.
	 * @param turn The turn to check.
	 * @return true if the turn is valid, false if is not.
	 */
	public boolean isValidTurn(int turn) {

		/*
		 * Add your code for this method here./
		 */

		return false;
	}

	/**
	 * This method effectively converts the keyboard input into a valid turn. The keyboard
	 * input is in the form of a String and will represent the key pressed by the player.
	 * The player presses 'r' for rock, 'p' for paper and 's' for scissors. This method converts
	 * that input into a valid turn, represented as an integer in the range 1-3. If the parameter
	 * 'input' does not contain 'r' or 'p' or 's' this method should return the value -1.
	 * @param input The turn selected by the player. Options described above.
	 * @return The turn as an integer. 1 means rock, 2 means paper, 3 means scissors. A return
	 * value of -1 means that the parameter was invalid.
	 */
	public int getPlayerTurn(String input) {

		/*
		 * Add your code for this method  here.
		 */

		return -1;
	}

	/**
	 * This method decides which of the two players - the player or the computer - has won the round.
	 * The winner is decided as follows:
	 * - rock beats scissors
	 * - paper beats rock
	 * - scissors beats paper
	 * - if the the players choose the same object the round is a draw.
	 * @param playerChoice The player's turn.
	 * @param computerChoice The computer's turn.
	 * @return The winner, according to the rules above. If the player wins the method should
	 * return 'PLAYER', if the computer wins the method should return 'COMPUTER', and if it's a
	 * draw the method should return 'DRAW'.
	 */
	public String getWinner(int playerChoice, int computerChoice) {


		/*
		 * Add your code for this method  here.
		 */

		return DRAW;
	}

	/**
	 * This method effectively converts a turn represented as an integer to a String.
	 * If the parameter has the value 1 the method should return 'ROCK'.
	 * If the parameter has the value 2 the method should return 'PAPER'.
	 * If the parameter has the value 3 the method should return 'SCISSORS'.
	 * @param turn The turn to convert to a String.
	 * @return The turn as a String.
	 */
	public String getTurnAsString(int turn) {

		/*
		 * Add your code for this method  here.
		 */

		return null;
	}

/* ************************************************************************************

You do not need to look at the code below this point. If you are curious, however, feel
free. Do not change anything below this point though or your own code might not work.

*/

	private final static int IROCK = 1;
	private final static int IPAPER = 2;
	private final static int ISCISSORS = 3;

	private final static String ROCK_INPUT = "r";
	private final static String PAPER_INPUT = "p";
	private final static String SCISSORS_INPUT = "s";

	private final static String ROCK = "Rock";
	private final static String PAPER = "Paper";
	private final static String SCISSORS = "Scissors";

	private final static String PLAYER = "PLAYER";
	private final static String COMPUTER = "COMPUTER";
	private final static String DRAW = "DRAW";

	private Random rand = new Random(System.currentTimeMillis());

	private int playerWins;
	private int computerWins;

	private void run() {

		System.out.println("Choose rock ('r' key), paper ('p' key) or scissors ('s' key). Press 'x' to quit.");
		Scanner sc = new Scanner(System.in);

		String splayerTurn = sc.nextLine();

		while (!splayerTurn.equals("x")) {

			int playerTurn = getPlayerTurn(splayerTurn);

			if (!isValidTurn(playerTurn)) {
				System.out.println("Invalid input.");
			}

			else {

				int computerTurn = getRandomTurn();

				System.out.println("The player chose " + getTurnAsString(playerTurn) + " and the computer chose " + getTurnAsString(computerTurn));

				String result = getWinner(playerTurn, computerTurn);

				recordWin(result);

				if (result.equals(DRAW)) {
					System.out.println("The game is a draw.");
				}

				else {
					System.out.println("The winner is the " + result + ".");
				}
			}

			splayerTurn = sc.nextLine();
		}

		sc.close();

		System.out.println("Quitting.");

		System.out.println("The player won " + getPlayerWins() + " time(s).");
		System.out.println("The computer won " + getComputerWins() + " time(s).");
	}

	private int getRandomTurn() {
		return rand.nextInt(3)+1;
	}

	/**
	 * This method records a win for either the player or the computer based on the parameter 'result'.
	 * If the value of the parameter is 'PLAYER' the method increments the number of player wins.
	 * If the value of the parameter is 'COMPUTER' the method increments the number of computer wins.
	 * @param result the player who has won. Either 'PLAYER' or 'COMPUTER'.
	 */
	private void recordWin(String result) {

		if (result.equals(PLAYER)) {
			addPlayerWin();
		}

		if (result.equals(COMPUTER)) {
			addComputerWin();
		}
	}

	/**
	 * This method returns the number of times the player has won.
	 * @return The number of times the player has won.
	 */
	private int getPlayerWins() {
		return playerWins;
	}

	/**
	 * This method returns the number of times the computer has won.
	 * @return The number of times the computer has won.
	 */
	private int getComputerWins() {
		return computerWins;
	}

	/**
	 * This method adds 1 to the number of player wins.
	 */
	private void addPlayerWin() {
		++playerWins;
	}

	/**
	 * This method adds 1 to the number of computer wins.
	 */
	private void addComputerWin() {
		++computerWins;
	}

	public static void main(String[] args) {
		new RockPaperScissors().run();
	}
}
