package com.company;

import java.util.*;
import java.io.*;

/**
 * @author Sterling Jeppson
 * @version 1.0
 * @since 1.2
 *
 * purpose is to represent a generic address book
 */
public class AddressBook {

    /**
     * the data structures that will hold the data for the address book. Composed of a TreeMap
     * where the key is a String(the last name of the AddressEntry and the value is the a TreeSet
     * AddressEntry. This is because java does not contain a multiset in standard libraries.
     * Tree is used instead of hash because tree preserves the natural ordering of key which makes printing in
     * sorted order by last name(key) easy.
     */
    private final TreeMap<String, TreeSet<AddressEntry>> addressEntryList = new TreeMap<>();

    /**
     * prints to the console all of the Addresses contained in the AddressBook
     */
    public void list() {
        System.out.print(this.toString());
    }

    /**
     *
     * @param lastName is the last name(or some initial consecutive chars) of the person contained
     *                 in the AddressEntry to be removed
     *
     * First we get the prefixSet which is the set of all AddressEntry that have the first consecutive
     * of the lastName of AddressEntry match the lastName parameter passed. If the size of the set is 1 then
     * print out AddressEntry and prompt user if they wish to delete. If more than 1 element in set then print all
     * elements and ask user to select element based on index.
     */
    public void remove(String lastName) {
        TreeSet<AddressEntry> s = this.getPrefixSet(lastName);
        Scanner keyboard = new Scanner(System.in);
        try {
            if (s.size() == 1) {
                System.out.println("The following entry was found in the address book.");
                System.out.printf("%-3s" + s.first() + "\n", " ");
                System.out.println("Hit 'y' to remove the entry or 'n' to return to main menu");
                if (keyboard.nextLine().compareTo("y") == 0)
                    addressEntryList.get(s.first().getLastName()).remove(s.first());
            } else if (s.size() > 1) {
                ArrayList<AddressEntry> list = new ArrayList<>();
                int i = 1;
                System.out.println("The following entries were found in the address book," +
                        "select number of entry you wish to remove:\n");
                for (AddressEntry entry : s) {
                    list.add(entry);
                    System.out.printf("%-3s" + entry + "\n\n", i + ":");
                    i++;
                }
                int removalIndex = keyboard.nextInt() - 1;
                keyboard.nextLine();
                if(removalIndex < list.size() && removalIndex >= 0)
                    System.out.println("Hit 'y' to remove the following entry or 'n' to return to main menu:\n");
                System.out.printf("%-3s" + list.get(removalIndex) + "\n\n", "  ");
                if (keyboard.nextLine().compareTo("y") == 0) {
                    TreeSet<AddressEntry> set = addressEntryList.get(list.get(removalIndex).getLastName());
                    set.remove(list.get(removalIndex));
                }
            } else
                System.out.println("No entries with last name " + lastName + " were found.");
        }
        catch(InputMismatchException e) {
            System.out.println("Error: You need to enter a valid integer. No action taken.");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid element selection. No action taken.");
        }
    }

    /**
     *
     * @param entry is an instance of AddressEntry to add to the AddressBook
     *
     * If the key has never been seen before then a new TreeSet is created to contain the entry.
     * If the key has been seen before then entry is simply added to the correct set.
     */
    public void add(AddressEntry entry) {
        addressEntryList.computeIfAbsent(entry.getLastName(), k -> new TreeSet<>()).add(entry);
    }

    /**
     *
     * @param filename is a string which is the name of a text file that contains address Entry data in a certain format
     *
     *the format is firstName\nlastName\nAdress\ncity\nState\nzip\nemail\nphoneNumber
     */
    public void readFromFile(String filename) {
        try{
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while((line=br.readLine()) != null) {
                this.add(new AddressEntry(line, br.readLine(), br.readLine(), br.readLine(),
                                          br.readLine(), Integer.parseInt(br.readLine()), br.readLine(), br.readLine()));
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param startOf_lastName is a string which contains either a full last name or the first consecutive chars
     * of a last name in an AddressEntry
     */
    public void find(String startOf_lastName) {
        SortedMap<String, TreeSet<AddressEntry>> tempMap;
        tempMap = addressEntryList.subMap(startOf_lastName, startOf_lastName + Character.MAX_VALUE);
        if(tempMap.size() > 0) {
            int i = 1;
            System.out.println("The following " + tempMap.size() + " entries were found in the address book" +
                    "for a last name starting with " + "\"" + startOf_lastName + "\"");
            for(Map.Entry<String, TreeSet<AddressEntry>> entry : tempMap.entrySet()) {
                for(AddressEntry item : entry.getValue()) {
                    System.out.printf("%-3s" + item + "\n\n", i + ":");
                    i++;
                }
            }
        }
        else
            System.out.println("There were no entries were found in the address book" +
                    "for a last name starting with " + "\"" + startOf_lastName + "\"");
    }

    /**
     *
     * @param startOf_lastName full last name or start of last name
     * @return A TreeSet which contains all of the AddressEntry instances whose lastName field
     * matches from the start every char provided in startOf_lastName.
     */
    private TreeSet<AddressEntry> getPrefixSet(String startOf_lastName) {
        SortedMap<String, TreeSet<AddressEntry>> tempMap;
        TreeSet<AddressEntry> tempSet = new TreeSet<>();
        tempMap = addressEntryList.subMap(startOf_lastName, startOf_lastName + Character.MAX_VALUE);

        for(Map.Entry<String, TreeSet<AddressEntry>> entry : tempMap.entrySet()) {
            tempSet.addAll(entry.getValue());
        }
        return tempSet;
    }

    /**
     * removes all AddressEntry from the AddressBook
     */
    public void clear() {
        addressEntryList.clear();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int i = 1;
        for(Map.Entry<String, TreeSet<AddressEntry>> entry : addressEntryList.entrySet()) {
            for(AddressEntry item : entry.getValue()) {
                if(item != null) {
                    result.append(String.format("%-3s" + item + "\n\n", i + ":"));
                    i++;
                }
            }
        }
        return result.toString();
    }
}
