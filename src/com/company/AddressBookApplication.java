package com.company;
import java.util.*;

/**
 * @author Sterling Jeppson
 * @version 1.9
 * @since 1.2
 *
 * purpose: This class is used to add data to and delete data from and query an address book
 */
public class AddressBookApplication {

    /**
     * creates an AddressBook initializes the AddressBook with some AddressEntry's and
     * then prompts the user to add, delete, list, and search for entries.
     * @param args command line arguments passed to main
     */
    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        initAddressBook(ab);
        runApp(ab);
    }

    /**
     * initializes 2 AddressEntry instances with hard-coded data. Then adds entries to AddressBook class passed to function.
     * @param ab is an instance of AddressBook class
     */
    public static void initAddressBook(AddressBook ab) {
        AddressEntry entry1 = new AddressEntry("Sterling", "Jeppson",
                                                "2759 Vine Dr.","Livermore",
                                                "CA", 94550, "925-289-6963",
                                                             "sterlingijeppson@gmail.com");
        AddressEntry entry2 = new AddressEntry("D.S", "Malik",
                "2759 Vine Dr.","Livermore",
                "CA", 94550, "925-289-6963",
                "sterlingijeppson@gmail.com");
        ab.add(entry1);
        ab.add(entry2);
    }

    /**
     * prompts user for various commands to modify and display the AddressBook instance passed to it
     * @param ab is an instance of AddressBook class
     */
    public static void runApp(AddressBook ab) {
        Scanner keyboard = new Scanner(System.in);
        String answer;
        boolean continueLoop = true;
        while(continueLoop) {
            Menu.display_Menu();
            answer = keyboard.nextLine();
            switch (answer) {
                case "a":
                    System.out.println("Enter in FileName:");
                    ab.readFromFile(keyboard.nextLine());
                    break;
                case "b":
                    ab.add(Menu.prompt_All());
                    break;
                case "c":
                    System.out.println("Enter in Last Name of contact to remove:");
                    ab.remove(keyboard.nextLine());
                    break;
                case "d":
                    System.out.println("Enter in all or beginning of last name you wish to find:");
                    ab.find(keyboard.nextLine());
                    break;
                case "e":
                    ab.list();
                    break;
                case "f":
                    System.out.println("Quitting.");
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Error: " + answer + " is not a valid selection.");
            }
        }
    }
}
