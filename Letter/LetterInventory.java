/*
 * Name: Ian Thorgeirson
 * Course: CS 145 Hybrid
 * Date: 5/09/2022
 * Assignment: Lab 3: Letter Inventory
 * Purpose: This program will keep track of how many letters are
 * in a given String
 */

package Letter;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class LetterInventory {
	private int size;
	private int[] letterCounter; // makes an array of letter counters.

	// Constructs an inventory (a count) of the alphabetic letters in the given
	// string, ignoring the case of letters and ignoring any non-alphabetic 
	// characters.
	public LetterInventory(String input) {
		letterCounter = new int[26]; // there are 26 letters in the Latin alphabet
		input = input.toLowerCase();
		for (int i = 0; i < input.length(); i++) {
			if (Character.isLetter(input.charAt(i))) {
				size++;
				letterCounter[input.charAt(i) - 'a']++;
			}
		}
	}

	// Returns a count of how many of the given letter is in the inventory.
	public int get(char ch) {
		if (!Character.isLetter(ch)) { // if character is non-alphabetic
			throw new IllegalArgumentException();
		}
		ch = Character.toLowerCase(ch);
		return letterCounter[ch - 'a'];
	}

	// Sets the count for the given letter to the given value.
	public void set(char ch, int letterValue) {
		if (!Character.isLetter(ch) || letterValue < 0) { // if character is non-alphabetic
			throw new IllegalArgumentException();
		}
		ch = Character.toLowerCase(ch);
		size -= letterCounter[ch - 'a'];
		letterCounter[ch - 'a'] = letterValue;
		size += letterValue;
	}

	// Returns the sum of all of the counts in the inventory.
	public int size() {
		return size;
	}

	// Checks to see if the inventory is empty.
	// If it is, return true.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns a String representation of the inventory with the
	// letters all in lowercase and in sorted order. It also returns
	// how many of each letter was in the String.
	public String toString(String input) {
		String result = "";
		String str = input;
		str = str.toLowerCase(); // in order to avoid confusion

		// Create a new tree map that takes in a char array that is made from
		// the input string.
		Map<Character, Integer> charMap = new TreeMap<>();
		char[] arr = str.toCharArray();

		// Go through each element and set it's value to a map entry
		for (char value : arr) {
			if (Character.isAlphabetic(value)) {
				if (charMap.containsKey(value)) {
					charMap.put(value, charMap.get(value) + 1);

				} else {
					charMap.put(value, 1);
				}
			}
		}

		// Go through each map entry and print out it's value.
		for (Entry<Character, Integer> entry : charMap.entrySet()) {
			result += "\nThe letter " + entry.getKey() + " occurs " + entry.getValue().toString() + " times.";
		}
		return result;
	}

	// Constructs and returns a new LetterInventory object that represents
	// the sum of the letter inventory and the other given LetterInventory.
	public LetterInventory add(LetterInventory other) {
		LetterInventory sum = new LetterInventory("");
		for (int i = 0; i < 26; i++) { // there are 26 letters in the Latin Alphabet
			char ch = (char) ('a' + i);
			int value = letterCounter[i] - other.get(ch);
			sum.set(ch, value);
		}
		return sum;
	}

	// Constructs and returns a new LetterInventory object that represents
	// the result of subtracting the other inventory from the original
	// inventory
	public LetterInventory subtract(LetterInventory other) {
		LetterInventory difference = new LetterInventory("");
		for (int i = 0; i < 26; i++) { // there are 26 letters in the Latin alphabet
			char ch = (char) ('a' + i);
			int value = letterCounter[i] - other.get(ch);
			if (value < 0) {
				return null;
			}
			difference.set(ch, value);
		}
		return difference;
	}

	// main method
	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			String input;
			System.out.println("Please enter a string of text. (Up to 256 characters)");
			input = console.nextLine();

			// if user typed at least 256 characters
			while (input.length() >= 256) {
				System.out.println("Too long of an entry. Try a shorter entry.");
				input = console.nextLine();
			}

			input.replaceAll("\\W", ""); // removes all non-alphabetic characters
			LetterInventory string = new LetterInventory(input);
			System.out.println("There are " + string.size + " letters in this string.");
			System.out.println(string.toString(input)); // print the sorted list
		}
	}
}