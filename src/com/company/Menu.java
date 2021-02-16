package com.company;

import java.util.*;

/**
 * @author Sterling Jeppson
 * @version 1.0
 * @since 1.2
 *
 * purpose: This class is used to provide prompt to the user to create enter in data to an
 * AddressEntry
 */
public class Menu {

    /**
     * to get input from the user
     */
    private final static Scanner keyboard = new Scanner(System.in);

    /**
     *
     * @return a String which represents persons FirstName in an AddressEntry
     */
    public static String prompt_FirstName() {
        System.out.println("First Name: ");
        return keyboard.nextLine();
    }

    /**
     *
     * @return a String which represents persons LastName in an AddressEntry
     */
    public static String prompt_LastName() {
        System.out.println("Last Name: ");
        return keyboard.nextLine();
    }

    /**
     *
     * @return a String which represents persons street in an AddressEntry
     */
    public static String prompt_Street() {
        System.out.println("Street: ");
        return keyboard.nextLine();
    }

    /**
     *
     * @return a String which represents persons city in an AddressEntry
     */
    public static String prompt_City() {
        System.out.println("City: ");
        return keyboard.nextLine();
    }

    /**
     *
     * @return a String which represents persons state in an AddressEntry
     */
    public static String prompt_State() {
        System.out.println("State: ");
        return keyboard.nextLine();
    }

    /**
     *
     * @return an int which represents persons zip in an AddressEntry
     */
    public static int prompt_Zip() {
        try {
            Scanner Keyboard = new Scanner(System.in);
            System.out.println("Zip: ");
            return Keyboard.nextInt();
        }
        catch(InputMismatchException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     *
     * @return a String which represents persons PhoneNumber in an AddressEntry
     */
    public static String prompt_Telephone() {
        System.out.println("Telephone: ");
        return keyboard.nextLine();
    }

    /**
     *
     * @return a String which represents persons email in an AddressEntry
     */
    public static String prompt_Email() {
        System.out.println("Email: ");
        return keyboard.nextLine();
    }

    /**
     *
     * @return an AddressEntry which contains information specified by user
     */
    public static AddressEntry prompt_All() {
        return new AddressEntry(prompt_FirstName(), prompt_LastName(), prompt_Street(),
                                prompt_City(), prompt_State(), prompt_Zip(), prompt_Telephone(),
                                prompt_Email());
    }

    /**
     *
     * Prints out a menu which prompts user for selection of operation to be performed on
     * AddressBook
     */
    public static void display_Menu() {
        System.out.println( "*************************" +
                            "\nPlease enter your menu selection" +
                            "\na) Loading From File" +
                            "\nb) Addition" +
                            "\nc) Removal" +
                            "\nd) Find" +
                            "\ne) Listing" +
                            "\nf) Quit" +
                            "\n*************************");
    }

}
