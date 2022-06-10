/*
 * Name: Ian Thorgeirson
 * Course: CS 145 Hybrid
 * Date: 4/23/2022
 * Assignment: Lab 4: Deck of Cards
 * Purpose: This class prepares the deck of cards to be used 
 * in the War game.
 */

package Cards;

import java.util.Random;

public class DeckOfCards {
	// random number generator
	private static final Random randomNumber = new Random();
	private static final int NUMBER_OF_CARDS = 52;
	
	private Card[] deck = new Card[NUMBER_OF_CARDS];
	private int currentCard;
	
	// constructor to initalize variables
	public DeckOfCards() {
		currentCard = 0;
		// populate the deck with Card objects
		for (int count = 0; count < deck.length; count++) {
			deck[count] = new Card(count);
		}
	}
	
	// shuffle deck of Cards
	public void shuffle() {
		currentCard = 0;
		
		// for each Card, pick another random Card (0-51) and swap them
		for (int first = 0; first < deck.length; first++) {
			// select a random number between 0 and 51
			int second = randomNumber.nextInt(NUMBER_OF_CARDS);
			
			// swap current Card with randomly selected card
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}
	
	// deal a single card
	public Card dealCard() {
		// determine whether Cards remain to be dealt
		if (currentCard < deck.length) {
			return deck[currentCard++]; // return current Card in array
		} else {
			return null; // to indicate that all Cards were dealt
		}
	}
}