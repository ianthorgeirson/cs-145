/*
 * Name: Ian Thorgeirson
 * Course: CS 145 Hybrid
 * Date: 5/09/2022
 * Assignment: Assignment 2: Phonebook
 * Purpose: This class is part of the larger Phonebook package. This specific
 * class contains the main method where the actual program will run.
 */

package Phonebook;

import java.util.Scanner;

public class PhonebookTest {
	// main method used to run program and call other methods
	public static void main(String[] args) {
		PhonebookManager phonebook = new PhonebookManager(); // used to call other classes
		boolean run = true; // makes sure the program is running

		try (Scanner input = new Scanner(System.in)) { // to check for exceptions
			// initialize variables used for phonebook entries
			String firstName = "";
			String lastName = "";
			String address = "";
			String city = "";
			String phoneNumber = "";

			// add sample entries to the phonebook
			phonebook.add("David", "Bowie", "1234 Main St", "Bellingham, WA 98226", "3605954526");
			phonebook.add("Paul", "McCartney", "3 Abbey Road", "Bellingham, WA 98226", "3604561237");
			phonebook.add("Jack", "Sparrow", "458 Alabama St", "Bellingham, WA 98226", "3601234567");
			phonebook.add("John", "Smith", "666 Northwest Dr", "Bellingham, WA 98226", "3608675309");

			System.out.println("Welcome to the Bellingham Phonebook!");
			while (run) {
				System.out.println();
				int option = menu(input); // assign option to user choice from menu

				// call other methods based on user input
				switch (option) {
				case 1: // add
					addEntry(phonebook, firstName, lastName, address, city, phoneNumber, input);
					break;
				case 2: // edit
					editEntry(phonebook, firstName, lastName, address, city, phoneNumber, input);
					break;
				case 3: // delete
					deleteEntry(phonebook, input);
					break;
				case 4: // view entire phonebook
					System.out.println();
					System.out.println(phonebook);
					System.out.println();
					break;
				case 5: // view single entry
					viewEntry(phonebook, firstName, input);
					break;
				case 6: // quit
					System.out.println("Thank you for using the Phonebook.");
					run = false; // ends the program
					break;
				default: // any other option
					System.out.println("Not a valid option. Please try again.");
					break;
				}
			}
		}
	}

	// display a user menu of options and have user choose one of the options
	public static int menu(Scanner input) {
		System.out.println("Here are the available options:");
		System.out.println("\t1: add an entry to the phonebook.");
		System.out.println("\t2: edit an entry in the phonebook.");
		System.out.println("\t3: delete an entry in the phonebook.");
		System.out.println("\t4: view the phonebook entries.");
		System.out.println("\t5: view a specific phonebook entry.");
		System.out.println("\t6: quit the program.");
		System.out.println();
		System.out.println("Select an option: ");
		int option = input.nextInt();
		return option;
	}

	// user chooses 1. Add an entry to the phonebook based on given information
	public static void addEntry(PhonebookManager phonebook, String firstName, String lastName, String address,
			String city, String phoneNumber, Scanner input) {

		// obtain contact information from user.
		input.nextLine();
		System.out.println("First name: ");
		firstName = input.nextLine();
		System.out.println("Last name: ");
		lastName = input.nextLine();
		System.out.println("Street address: ");
		address = input.nextLine();
		System.out.println("City, state, and ZIP: ");
		city = input.nextLine();
		System.out.println("Phone number: ");
		phoneNumber = input.nextLine();

		// add information to phonebook
		phonebook.add(firstName, lastName, address, city, phoneNumber);
		System.out.println("Phonebook entry added!");
	}

	// get index of phonebook entry; used for viewing, editing, and removing
	// specific entry
	public static int getEntryIndex(PhonebookManager phonebook, Scanner input, String selection) {
		String lastName;
		lastName = selection;
		return phonebook.getIndex(lastName);
	}

	// user chooses 2. Edit a specific entry in the phonebook. User can edit the
	// individual name, address,
	// city, or phone number.
	public static void editEntry(PhonebookManager phonebook, String firstName, String lastName, String address,
			String city, String phoneNumber, Scanner input) {
		boolean menu = true;
		while (menu) {
			// user selects a specific entry
			System.out.println("Here is the current phonebook list:");
			System.out.println();
			System.out.println(phonebook);
			System.out.println();
			System.out.println("Select the entry you would like to change. Enter by last name.");
			input.nextLine();
			String selection = input.nextLine();
			int index = getEntryIndex(phonebook, input, selection); // used to get location of entry in the phonebook.

			// user chooses what to do with given entry
			System.out.println("What would you like to change?");
			System.out.println("\t1: First Name.");
			System.out.println("\t2: Last Name.");
			System.out.println("\t3: Address.");
			System.out.println("\t4: City, State, and ZIP.");
			System.out.println("\t5: Phone Number.");
			int choice = input.nextInt();
			input.nextLine();

			switch (choice) {
			case 1: // First Name
				System.out.println("What would you like to change the first name to? ");
				firstName = input.nextLine();
				phonebook.editFirstName(firstName, index);
				System.out.println("First name changed!");
				menu = false;
				break;
			case 2: // Last Name
				System.out.println("What would you like to change the last name to? ");
				lastName = input.nextLine();
				phonebook.editLastName(lastName, index);
				System.out.println("Last name changed!");
				menu = false;
				break;
			case 3: // Address
				System.out.println("What would you like to change the address to? ");
				address = input.nextLine();
				phonebook.editAddress(address, index);
				System.out.println("Address changed!");
				menu = false;
				break;
			case 4: // City, State, and ZIP
				System.out.println("What would you like to change the city to? ");
				city = input.nextLine();
				phonebook.editCity(city, index);
				System.out.println("City, state, and ZIP changed!");
				menu = false;
				break;
			case 5: // Phone Number
				System.out.println("What would you like to change the phone number to? ");
				phoneNumber = input.nextLine();
				phonebook.editPhoneNumber(phoneNumber, index);
				System.out.println("Phone number changed!");
				menu = false;
				break;
			default: // any other option
				System.out.println("Not an option. Try again.");
				choice = input.nextInt();
				break;
			}
		}
	}

	// user chooses 3. Delete a specific entry from the phonebook.
	public static void deleteEntry(PhonebookManager phonebook, Scanner input) {
		// user selects a specific entry
		System.out.println("Here is the current phonebook list:");
		System.out.println();
		System.out.println(phonebook);
		System.out.println();
		System.out.println("Select the entry you would like to delete. Enter by last name.");
		input.nextLine();
		String selection = input.nextLine();
		int index = getEntryIndex(phonebook, input, selection); // used to get location of entry in the phonebook.

		// remove the selected entry
		phonebook.remove(index);
		System.out.println("Phonebook entry deleted!");
	}

	// user chooses 5. View a specific entry in the phonebook based on last name.
	public static void viewEntry(PhonebookManager phonebook, String lastName, Scanner input) {
		System.out.println("Select the entry you would like to view. Enter by last name.");
		input.nextLine();
		String selection = input.nextLine();
		int index = getEntryIndex(phonebook, input, selection); // used to get location of entry in the phonebook.
	
		// print the specific entry
		System.out.println();
		System.out.println(phonebook.printEntry(index, selection));
	}
}