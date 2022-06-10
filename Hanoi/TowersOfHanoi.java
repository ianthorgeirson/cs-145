/*
 * Programmer: Ian Thorgeirson
 * Date: 05/23/2022
 * Class: CS 145 Hybrid: Data Structures in Java
 * Assignment: Lab 5: Towers of Hanoi
 * Description: This program is a recursive solution to the Towers of Hanoi
 * problem. The puzzle involves manipulating disks that you can move between
 * 3 different towers. You are given 4 disks stacked on three towers. The disks
 * have decreasing diameters, with the smallest disk on the top. The disks must
 * be arranged, from top to bottom, largest to smallest. You cannot place a
 * bigger disk on a smaller disk.
 */

package Hanoi;

import java.util.*;

public class TowersOfHanoi {
	
	// recursive method that solves the puzzle
	public void tOH(int n, String start, String end, String spare) {
		if (n == 0) { // needed for recursion 
			return;
		} else {
			tOH(n - 1, start, spare, end);
			System.out.println("Move disk " + n + " from tower " + start + " to tower " + end);
			tOH(n - 1, spare, end, start);
		}
	}

	// main method
	public static void main(String[] args) {
		// make a new object of type TowersOfHanoi
		TowersOfHanoi tower = new TowersOfHanoi();
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("How many discs are there? ");
			int disc = input.nextInt(); // number of discs
			tower.tOH(disc, "A", "C", "B"); // A, B, and C are the names of the towers.
		}
	}
}