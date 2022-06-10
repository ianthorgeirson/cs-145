/*
 * Name: Ian Thorgeirson
 * Course: CS 145 Hybrid
 * Date: 4/23/2022
 * Assignment: Lab 4: Deck of Cards
 * Purpose: This program will prepare the classes needed 
 * to run the main method.
 */

package Cards;

public class Card {

	private int cardNum = 0;
    final static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    final static String[] faces = {"2", "3","4","5","6","7","8", "9","10", "Jack", "Queen", "King", "Ace"};

    // constructor that creates a card number value
	public Card(int theCard) {
		setCardNum(theCard);
	}
	
	// sets value of card to cardNum
	public void setCardNum(int theCard) {
		cardNum = (theCard >= 0 && theCard <= 51) ? theCard : 0;
	}

	// getter method
	public int getCardNum() {
		return cardNum;
	}
	
	// prints out the value of the card
	@Override
	public String toString() {
		return faces[cardNum % 13] + " of " + suits[cardNum / 13];
	}
	
	// gets value of suit
	public String getSuit() {
		return suits[cardNum / 13];
	}
	
	// gets value of face
	public String getFace() {
		return faces[cardNum % 13];
	}
	
	// used for determining winner in War
	public int getValue() {
		return cardNum % 13;
	}
}