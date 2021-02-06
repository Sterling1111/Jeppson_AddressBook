package com.company;

import java.util.*;

public class Menu {

    private final static Scanner keyboard = new Scanner(System.in);

    public static String prompt_FirstName() {
        System.out.println("First Name: ");
        return keyboard.nextLine();
    }

    public static String prompt_LastName() {
        System.out.println("Last Name: ");
        return keyboard.nextLine();
    }

    public static String prompt_Street() {
        System.out.println("Street: ");
        return keyboard.nextLine();
    }

    public static String prompt_City() {
        System.out.println("City: ");
        return keyboard.nextLine();
    }

    public static String prompt_State() {
        System.out.println("State: ");
        return keyboard.nextLine();
    }

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

    public static String prompt_Telephone() {
        System.out.println("Telephone: ");
        return keyboard.nextLine();
    }

    public static String prompt_Email() {
        System.out.println("Email: ");
        return keyboard.nextLine();
    }

    public static AddressEntry prompt_All() {
        return new AddressEntry(prompt_FirstName(), prompt_LastName(), prompt_Street(),
                                prompt_City(), prompt_State(), prompt_Zip(), prompt_Telephone(),
                                prompt_Email());
    }

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
