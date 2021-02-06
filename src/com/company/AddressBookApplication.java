package com.company;
import java.util.*;
public class AddressBookApplication {

    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        initAddressBook(ab);
        runApp(ab);
        System.out.println(ab);
    }

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
