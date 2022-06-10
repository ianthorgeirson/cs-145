/*
 * Name: Ian Thorgeirson
 * Course: CS 145 Hybrid
 * Date: 5/09/2022
 * Assignment: Assignment 2: Phonebook
 * Purpose: This class is part of the larger Phonebook package. This specific
 * class does the work of modifying the phonebook entries, including adding, 
 * editing, deleting, viewing, etc.
 */

package Phonebook;

public class PhonebookManager {
	private PhonebookNode front;

	// creates a new empty Phonebook node
	public PhonebookManager() {
		front = null;
	}

	// returns the number of phonebook entries
	public int size() {
		int count = 0;
		PhonebookNode current = front;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	// returns the index of the entry containing a given last name.
	// returns -1 if not found or is empty.
	public int getIndex(String lastName) {
		int index = 0;
		PhonebookNode current = front;

		if (front == null) { // if phonebook is empty
			return -1;
		}
		while (current != null) {
			if (current.lastName.toLowerCase().equals(lastName.toLowerCase())) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}

	// adds a given phonebook entry to the list in alphabetical order based on
	// last name
	public void add(String firstName, String lastName, String address, String city, String phoneNumber) {
		int index = 0;
		if (front == null) {
			addIndex(firstName, lastName, address, city, phoneNumber, 0);
		} else {
			PhonebookNode current = front;
			while (current.next != null) {
				if (lastName.compareTo(lastName) < 0) {
					addIndex(firstName, lastName, address, city, phoneNumber, index);
				}
				current = current.next;
				index++;
			}
			current.next = new PhonebookNode(firstName, lastName, address, city, phoneNumber);
		}
	}

	// adds a given phonebook entry at a given index
	public void addIndex(String firstName, String lastName, String address, String city, String phoneNumber,
			int index) {
		if (index == 0) {
			front = new PhonebookNode(firstName, lastName, address, city, phoneNumber);
		} else {
			PhonebookNode current = nodeAt(index - 1);
			current.next = new PhonebookNode(firstName, lastName, address, city, phoneNumber);
		}
	}

	// removes a given phonebook entry at a given index
	public void remove(int index) {
		if (index == 0) {
			front = front.next;
		} else {
			PhonebookNode current = nodeAt(index - 1);
			current.next = current.next.next;
		}
	}

	// returns a reference to the phonebook entry at a given index
	private PhonebookNode nodeAt(int index) {
		PhonebookNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	// And now come the methods used for editing phonebook entries. Oh boy.

	// edits the first name of a given phonebook entry to a given String
	public void editFirstName(String firstName, int index) {
		PhonebookNode current = nodeAt(index);
		current.firstName = firstName;
	}

	// edits the last name of a given phonebook entry to a given String
	public void editLastName(String lastName, int index) {
		PhonebookNode current = nodeAt(index);
		current.lastName = lastName;
	}

	// edits the address of a given phonebook entry to a given String
	public void editAddress(String address, int index) {
		PhonebookNode current = nodeAt(index);
		current.address = address;
	}

	// edits the city of a given phonebook entry to a given String
	public void editCity(String city, int index) {
		PhonebookNode current = nodeAt(index);
		current.city = city;
	}

	// edits the phone number of a given phonebook entry to a given String
	public void editPhoneNumber(String phoneNumber, int index) {
		PhonebookNode current = nodeAt(index);
		current.phoneNumber = phoneNumber;
	}

	// returns the contents of the entire phonebook
	@Override
	public String toString() {
		if (front == null) {
			return "Phonebook is empty.";
		} else {
			String result = front.lastName + ", " + front.firstName + " :: " + front.address + ", "
					+ front.city + " :: " + front.phoneNumber;
			PhonebookNode current = front.next;
			while (current != null) {
				result += "\n" + current.lastName + ", " + current.firstName + " :: " + current.address
						+ ", " + current.city + " :: " + current.phoneNumber;
				current = current.next;
			}
			return result;
		}
	}
	
	// returns the contents of a single phonebook entry
	public String printEntry(int index, String selection) {
		String result = "";
		if (index == -1) {
			return "Entry doesn't exist";
		} else {
			PhonebookNode current = nodeAt(index);
			if (current != null) {
				result = current.lastName + ", " + current.firstName + " :: " + current.address
						+ ", " + current.city + " :: " + current.phoneNumber;
				current = current.next;
			}
			return result;
		}
	}
}