package WordSearchGenerator;

/*
 * Ian Thorgeirson
 * Date: 5/31/2022
 * Class: CS 145 Hybrid: Data Structures w/ Java
 * Assignment: Assignment 1: Word Search Generator
 * Purpose: This program takes in a certain number of words from the user and 
 * generates a word search using those words. This is the class that runs the 
 * program. It calls on the other class to run its various methods.
 */

import java.util.*; // "Scanner", for user input.

public class WordSearchGeneratorMain {
	public static void main(String[] args) {
		boolean generated = false; // to make sure the word search is generated.
		try (Scanner console = new Scanner(System.in)) {
			String choice;
			WordSearchGenerator search = new WordSearchGenerator(); // use this to call on other class.
			do {
				printIntro();
				choice = console.next();
				choice = choice.toLowerCase(); // in case user types in uppercase.
				switch (choice) {
				case "g":
					setUpGenerator(search, console);
					generated = true; // tells the program that the word search is generated.
					break;
				case "p":
					if (generated) { // if the word search is generated
						print(search);
					}
					break;
				case "s":
					if (generated) { // if the word search is generated.
						showSolution(search);
					}
					break;
				default: // any other character
					System.out.println("Not a valid option. Try again.");
					break;
				}
			} while (!choice.equals("q")); // if user picks "q", program ends.
		}
	}

	// Prints an intro to the program which explains and lists options.
	public static void printIntro() {
		System.out.println("Welcome to my word search generator!");
		System.out.println("This program will allow you to generate your own word search puzzle");
		System.out.println("Please select and option:");
		System.out.println("Generate a new word search (g)");
		System.out.println("Print out your word search (p)");
		System.out.println("Show the solution to your word search(s)");
		System.out.println("Quit the prograrm (q)");
	}

	// User picks "g".Sets up the word search generator by asking for words 
	// to be put on the word search.
	public static ArrayList<String> setUpGenerator(WordSearchGenerator search, Scanner console) {
		System.out.println("Enter words line by line. When finished, type a single \"q\"");
		String word = console.next();
		ArrayList<String> wordsAR = new ArrayList<String>();
		do {
			wordsAR.add(word);
			word = console.next();
		} while (!word.equals("q"));
		String[] words = new String[wordsAR.size()];
		wordsAR.toArray(words);
		search.generate(words);
		return wordsAR;
	}
	// Prints out the word search.
	public static void print(WordSearchGenerator ws) {
		System.out.println(ws);
	}

	// Prints out the solution to the word search.
	public static void showSolution(WordSearchGenerator ws) {
		System.out.println(ws.toSolution());
	}
}