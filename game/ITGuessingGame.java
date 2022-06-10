/*
 * Name: Ian Thorgeirson
 * Course: CS 145 Hybrid
 * Date: 4/07/2022
 * Assignment: Lab 1: Guessing Game
 * Purpose: This is the main method to a card game known as War.
 */

package game;

// import classes needed for program
import java.util.Random;
import java.util.Scanner;

public class ITGuessingGame {
	// to ensure user input throughout program
	private static Scanner input;

	/*
	 * define variables that will be used for the other methods in the program
	 */
	public static void main(String[] args) {
		input = new Scanner(System.in);

		// define variables
		int games = 0; // total number of games
		int sum = 0; // total number of guesses
		int numGuesses = 0; // number of guesses per round
		double average = 0.0; // guesses per game
		int bestGuesses = 10000; // to determine lowest number of guesses in a game
		instructions(); // start instructions

		// prompts user input
		System.out.print("Shall we play a game? ");
		String answer = input.next();
		char a = answer.charAt(0);

		// if user picks yes
		do {
			games++; // game count
			numGuesses = game(input);
			sum += numGuesses; // adds total number of guesses to sum

			// to determine lowest possible guesses per game
			if (numGuesses < bestGuesses) {
				bestGuesses = numGuesses;

			}
			// prompts user to play again
			System.out.print("Do you want to play again? ");
			answer = input.next();
			a = answer.charAt(0);
		} while (a == 'y' || a == 'Y');

		// if user picks no
		double sum1 = sum;
		double games1 = games;
		average = sum1 / games1;

		// head to summary
		summary(games, sum, average, bestGuesses);
	} // end of main method

	// display instructions of game.
	public static void instructions() {
		System.out.println("I'm in instructions!");
		System.out.println();
		System.out.println("This program allows you to play a guessing game.");
		System.out.println("I will think of a number between 1 and");
		System.out.println("1000 and will allow you to guess until");
		System.out.println("you get it. For each guess, I will tell you");
		System.out.println("whether the right answer is higher or lower");
		System.out.println("than your guess.");
		System.out.println();
	} // end of instructions method

	// plays game
	public static int game(Scanner input) {

		// pick a random number between 1 and 1000
		Random rand = new Random();
		int number = rand.nextInt(1000) + 1;
		int numGuesses = 1;

		System.out.println();

		// get first guess
		System.out.println("I'm thinking of a number between 1 and 1000...");
		System.out.print("Your guess? ");
		int guess = input.nextInt();

		while (number != guess) { // if guess is incorrect
			if (guess > number) { // guess is greater than answer
				System.out.println("Incorrect. It's lower.");
				System.out.print("Your guess? ");
				guess = input.nextInt();
				numGuesses++;
			} else { // guess is less than answer
				System.out.println("Incorrect. It's higher.");
				System.out.print("Your guess? ");
				guess = input.nextInt();
				numGuesses++;
			} // end of if/else
		} // end of while loop

		if (numGuesses == 1) { // if correct on first guess
			System.out.println("Wow! You got it right on the first try!");
		} else {
			System.out.println("You got it right in " + numGuesses + " guesses."); // if user guesses correctly
		}
		return numGuesses;
	} // end of game method

	// display a summary of game statistics to user.
	public static void summary(int games, int sum, double average, int bestGuesses) {
		System.out.println("Overall results:");
		System.out.println();
		System.out.println("total games = " + games);
		System.out.println("total guesses = " + sum);
		System.out.printf("average guesses per game = %.3f\n", average);
		System.out.println("best game = " + bestGuesses + " guesses");
	} // end of summary method
} // end ITLab1 class