/*
 * Ian Thorgeirson
 * Date: 6/07/2022
 * Class: CS 145 Hybrid: Data Structures w/ Java
 * Assignment: Lab 6: 20 Questions
 * Purpose: This program will play a simplified version of the popular
 * game "20 Questions." This class implements a binary tree system based 
 * on yes/no responses and creates constructors. 
 */

package twenty_questions;

public class QuestionNode {
	public String data; // String stored in this node
	public QuestionNode left; // reference to left subtree
	public QuestionNode right; // reference to right subtree

	// Constructs a leaf node with the given String and null links.
	public QuestionNode(String input) {
		this(input, null, null);
	}

	// Constructs a leaf or branch node with the given String and links.
	public QuestionNode(String input, QuestionNode left, QuestionNode right) {
		this.data = input;
		this.left = left;
		this.right = right;
	}

	// Returns true if the node is a leaf (has no children).
	public boolean isAnswer() {
		return (left == null) && (right == null);
	}
}