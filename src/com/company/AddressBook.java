package com.company;

import java.util.*;
import java.io.*;

public class AddressBook {

    private final TreeMap<String, TreeSet<AddressEntry>> addressEntryList = new TreeMap<>();

    public void list() {
        int i = 1;
        for(Map.Entry<String, TreeSet<AddressEntry>> entry : addressEntryList.entrySet()) {
            for(AddressEntry item : entry.getValue()) {
                if(item != null) {
                    System.out.printf("%-3s" + item + "\n\n", i + ":");
                    i++;
                }
            }
        }
    }

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
                        "select number of entry you wish to remove:");
                for (AddressEntry entry : s) {
                    list.add(entry);
                    System.out.printf("%-3s" + entry + "\n\n", i + ":");
                    i++;
                }
                int removalIndex = keyboard.nextInt() - 1;
                keyboard.nextLine();
                System.out.println("Hit 'y' to remove the following entry or 'n' to return to main menu:");
                System.out.println(list.get(removalIndex));
                if (keyboard.nextLine().compareTo("y") == 0) {
                    TreeSet<AddressEntry> set = addressEntryList.get(list.get(removalIndex).getLastName());
                    set.remove(list.get(removalIndex));
                }
            } else
                System.out.println("No entries with last name " + lastName + " were found.");
        }
        catch(InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void add(AddressEntry entry) {
        addressEntryList.computeIfAbsent(entry.getLastName(), k -> new TreeSet<>()).add(entry);
    }

    public void readFromFile(String filename) {
        try{
            File file = new File(filename);
            Scanner inputFile = new Scanner(file);

            while(inputFile.hasNext()) {
                String line = inputFile.nextLine();
                String[] tokens = line.split(" : ");
                this.add(new AddressEntry(tokens[0], tokens[1], tokens[2], tokens[3],
                                            tokens[4], Integer.parseInt(tokens[5]), tokens[6], tokens[7]));
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

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

    private TreeSet<AddressEntry> getPrefixSet(String startOf_lastName) {
        SortedMap<String, TreeSet<AddressEntry>> tempMap;
        TreeSet<AddressEntry> tempSet = new TreeSet<>();
        tempMap = addressEntryList.subMap(startOf_lastName, startOf_lastName + Character.MAX_VALUE);

        for(Map.Entry<String, TreeSet<AddressEntry>> entry : tempMap.entrySet()) {
            tempSet.addAll(entry.getValue());
        }
        return tempSet;
    }

    public void clear() {
        addressEntryList.clear();
    }

    public String toString() {
        StringBuilder result = new StringBuilder("");
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
