/*
 * Name: Ian Thorgeirson
 * Course: CS 145 Hybrid
 * Date: 5/09/2022
 * Assignment: Assignment 2: Phonebook
 * Purpose: This class is part of the larger Phonebook package. This specific
 * class initializes the contact information variables that will be used by the
 * PhonebookManager class.
 */

package Phonebook;

public class PhonebookNode {

	// initialize the variables to be used in the program
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String phoneNumber;
	public PhonebookNode next;

	// creates a new empty Phonebook node that stores phonebook information
	// doesn't make a reference to the next node.
	public PhonebookNode() {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.next = null;
	}

	// creates a new empty Phonebook node that stores phonebook information.
	// makes a reference to the next node.
	public PhonebookNode(String firstName, String lastName, String address, 
			String city, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.next = next;
	}
}