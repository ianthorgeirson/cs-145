package WordSearchGenerator;

/*
 * Ian Thorgeirson
 * Date: 5/31/2022
 * Class: CS 145 Hybrid: Data Structures w/ Java
 * Assignment: Assignment 1: Word Search Generator
 * Purpose: This program takes in a certain number of words from the user and 
 * generates a word search using those words. This is the class that does the dirty
 * work of creating and printing the word search.
 */

import java.util.*; // "Scanner", for user input.

public class WordSearchGenerator {
	private char[][] grid; // grid of the word search
	private boolean[][] sol; // solution to word search
	private String[] words; // list of words used to make the grid.

	// Accepts a parameter of a String array and generates 
	// a new word search from this array.
	public void generate(String[] w) { // w is the list of inputted words.
		for (int i = 0; i < w.length; i++) {
			w[i] = w[i].toLowerCase(); // makes all inputted words lowercase.
		}
		this.words = w;
		char[][] wordChars = setupGrid();
		for (int i = 0; i < wordChars.length; i++) {
			placeWord(wordChars, i); // places the word on the grid.
		}
		fillGrid();
	}

	// Returns a String representation of the word search grid
	public String toString() {
		String result = "";
		for (int i = 0; i < grid.length; i++) { // x-coordinate
			for (int j = 0; j < grid[i].length; j++) { // y-coordinate
				result += " " + grid[i][j] + " ";
			}
			result += "\r\n";
		}
		return result;
	}

	// Returns a String representation of the word search solution
	public String toSolution() {
		String result = "";
		for (int i = 0; i < grid.length; i++) { // x-coordinate
			for (int j = 0; j < grid[i].length; j++) { // y-coordinate
				if (sol[i][j]) { // if index of grid contains the inputted word
					result += " " + grid[i][j] + " ";
				} else {
					result += " X ";
				}
			}
			result += "\r\n";
		}
		return result;
	}

	// Places a word in the word search grid. Determines the direction 
	// of the word and finds a valid place.
	private void placeWord(char[][] wordChars, int iter) {
		Random rand = new Random();
		int direction = rand.nextInt(3); // makes the word go either horizontal, vertical, or diagonal
		int[] pos = {0, 0};
		if (direction == 0) { // horizontal
			boolean placed = false;
			int attempts = 0; // to make sure that the word isn't inputted 100 times
			while (!placed && attempts < 100) {
				pos[0] = rand.nextInt((grid.length - 1) - wordChars[iter].length); // random x-coordinate
				pos[1] = rand.nextInt((grid.length - 1) - wordChars[iter].length); // random y-coordinate
				placed = true;
				for (int i = 0; i < wordChars[iter].length; i++) {
					if (grid[pos[0] + i][pos[1]] != '\u0000' // u0000 is the Unicode character of NULL
							&& grid[pos[0] + i][pos[1]] != wordChars[iter][i]) {
						placed = false;
						break;
					}
				}
				attempts++;
			}
			if (placed) {
				for (int i = 0; i < wordChars[iter].length; i++) {
					grid[pos[0]][pos[1]] = wordChars[iter][i]; // puts it on the grid
					sol[pos[0]][pos[1]] = true; // adds the coordinates to the solution grid
					pos[0]++;
				}
			}
		} else if (direction == 1) { // vertical
			boolean placed = false;
			int attempts = 0;
			while (!placed && attempts < 100) {
				pos[0] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
				pos[1] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
				placed = true;
				for (int i = 0; i < wordChars[iter].length; i++) {
					if (grid[pos[0]][pos[1] + i] != '\u0000' // u0000 is the Unicode character for NULL
							&& grid[pos[0]][pos[1] + i] != wordChars[iter][i]) {
						placed = false;
						break;
					}
				}
				attempts++;
			}
			if (placed) {
				for (int i = 0; i < wordChars[iter].length; i++) {
					grid[pos[0]][pos[1]] = wordChars[iter][i];
					sol[pos[0]][pos[1]] = true;
					pos[1]++;
				}
			}
		} else if (direction == 2) { // diagonal
			boolean placed = false;
			int attempts = 0;
			while (!placed && attempts < 100) {
				pos[0] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
				pos[1] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
				placed = true;
				for (int i = 0; i < wordChars[iter].length; i++) {
					if (grid[pos[0] + i][pos[1] + i] != '\u0000' // u0000 is the Unicode character for NULL
							&& grid[pos[0] + i][pos[1] + i] != wordChars[iter][i]) {
						placed = false;
						break;
					}
				}
				attempts++;
			}
			if (placed) {
				for (int i = 0; i < wordChars[iter].length; i++) {
					grid[pos[0]][pos[1]] = wordChars[iter][i];
					sol[pos[0]][pos[1]] = true;
					pos[1]++;
					pos[0]++;
				}
			}
		}
	}

	// Breaks up the String array into a 2D char array and adjusts the size of the
	// grid based on the length and number of the words.
	private char[][] setupGrid() {
		char[][] wordChars = new char[words.length][];
		int longest = 8; // to allow for extra room for the grid to grow based on word size
		for (int i = 0; i < words.length; i++) {
			wordChars[i] = words[i].toCharArray();
			if (wordChars[i].length > longest) {
				longest = wordChars[i].length;
			}
		}
		if (words.length > longest) { // if word length is bigger than the longest word before...
			longest = words.length;
		}
		this.grid = new char[longest + 4][longest + 4]; // adds it to the grid
		this.sol = new boolean[longest + 4][longest + 4]; // adds it to the solution grid
		return wordChars;
	}

	// Fills the grid with random characters in all of the empty indexes.
	private void fillGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				Random rand = new Random();
				if (grid[i][j] == '\u0000') {
					// 26 letters in the Latin alphabet, 0097 is where the alphabet starts
					grid[i][j] = (char) (rand.nextInt(26) + 97);
					
				}
			}
		}
	}
}