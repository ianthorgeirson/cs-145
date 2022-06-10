/*
 * Name: Ian Thorgeirson
 * Course: CS 145 Hybrid
 * Date: 4/23/2022
 * Assignment: Lab 4: Deck of Cards
 * Purpose: This class runs the main method to play
 * the War card game.
 */

package Cards;

public class WarCardGame {

	// main method
	public static void main(String[] args) {
		Card[][] hands = new Card[2][1];
		DeckOfCards myDeck = new DeckOfCards();
		myDeck.shuffle();
		
		
		int player1 = 0;
		int player2 = 0;
		for (int i = 0; i < 26; i++) {
			System.out.printf("\n Round %s of The War \n", i);

			for (int c = 0; c < 1; c++) {
				for (int player = 0; player < hands.length; player++) {
					hands[player][c] = myDeck.dealCard();
				}
			}
			for (int player = 0; player < hands.length; player++) {
				System.out.printf("Player %d: ", player + 1);
				printHand(hands[player]);

				if (player1 > player2) {
					System.out.println("Player One Wins The War");
				} else if (player1 < player2) {
					System.out.println("Player Two Wins The War");
				} else {
					System.out.println("The War Is A Tie");
				}
			}
		}
	}

	// prints out card value
	public static void printHand(Card[] hand) {
		for (Card element : hand) {
			System.out.printf("%s", element.toString());
		}

		System.out.println();
	}

	// displays instructions of the War card game
	public static void instructions() {
		System.out.println("War is a card game for two players. A standard");
		System.out.println("deck of 52 cards is dealt so that both players");
		System.out.println("have 26 cards. During each round of play (or ");
		System.out.println("\"battle\"), both players play a card from the");
		System.out.println("top of their hand face up. The player who plays");
		System.out.println("the card of the higher rank wins both cards and");
		System.out.println("places them at the bottom of his stack of cards.");
		System.out.println("If both cards played are of the same rank, then");
		System.out.println("both players play three additional cards face down");
		System.out.println("and then one more card face up (this is called a ");
		System.out.println("\"war\"). The player who wins the war by playing the");
		System.out.println("higher card wins all ten cards. If the ranks are");
		System.out.println("still the same, additional wars are played until one");
		System.out.println("wins the turn. If either player runs out of cards to");
		System.out.println("play, he loses the game.");
	}
}