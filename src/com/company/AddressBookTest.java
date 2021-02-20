package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

class AddressBookTest {

    private static final ByteArrayOutputStream testOutput = new ByteArrayOutputStream();

    private AddressBook ab;

    private final AddressEntry ae1 = new AddressEntry("John", "A", "Arroyo", "Dublin", "NY", 81777, "boring@gmail.com", "925-123-7924");
    private final AddressEntry ae2 = new AddressEntry("John", "Doe", "Arroyo", "Dublin", "NY", 81777, "boring@gmail.com", "925-123-7924");
    private final AddressEntry ae3 = new AddressEntry("John", "Dof", "Arroyo", "Dublin", "NY", 81777, "boring@gmail.com", "925-123-7924");
    private final AddressEntry ae4 = new AddressEntry("John", "A", "Arroyo", "Dublin", "NY", 81777, "boring@gmail.com", "925-123-7924");

    /**
     * A method which sets standard output to print to testOutput instead of the console
     */
    @BeforeAll
    public static void setUp() {
        //We want to suppress the console output. We need to create a ByteArrayOutputStream so that
        //the console output can be placed somewhere. Then we tell System that we want the
        //standard output stream to a new PrintStream of our new ByteArrayOutputStream
        System.setOut(new PrintStream(testOutput));
    }

    @BeforeEach
    public void createAddressEntryObject() {
        this.ab = new AddressBook();
    }

    /**
     * A method which clears testOutput after every test has completed
     */
    @AfterEach
    public void cleanUp() {
        testOutput.reset();
    }

    private void provideInput(String data) {
        ByteArrayInputStream testInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);
    }

    /**
     * Test method for {@link AddressBook#list()}.
     */
    @Test
    void testList() {
        this.testToString();
    }

    /**
     * Test method for {@link AddressBook#remove(java.lang.String)}
     */
    @Test
    void testRemove() {
        String input = "y";
    }

    /**
     * Test method for {@link AddressBook#add(com.company.AddressEntry)}
     */
    @Test
    void testAdd() {
        ab.add(ae1);
        ab.add(ae4);

        String expected = "1: John A\n   Arroyo\n   Dublin, NY 81777\n   boring@gmail.com\n   925-123-7924\n\n";
        assertEquals(expected, ab.toString());
    }

    /**
     * Test method for {@link AddressBook#readFromFile(java.lang.String)}
     */
    @Test
    void testReadFromFile() {
        ab.readFromFile("test.txt");
        String expected = "";
        expected += "1: John A\n   Arroyo\n   Dublin, NY 81777\n   boring@gmail.com\n   111-234-7924\n\n";
        expected += "2: John Doe\n   Arroyo\n   Dublin, NY 81777\n   boring@gmail.com\n   111-234-7924\n\n";
        expected += "3: John Dof\n   Arroyo\n   Dublin, NY 81777\n   boring@gmail.com\n   111-234-7924\n\n";
        assertEquals(expected, ab.toString());
    }

    @Test
    void testFind() {
        ab.add(ae1);
        ab.add(ae2);
        ab.add(ae3);
        ab.add(ae4);
        String input1 = "";
        String input2 = "not here";
        String input3 = "A";
        String input4 = "D";

        ab.find(input1);
        String result1 = "The following 3 entries were found in the address book" +
                " for a last name starting with \"\"\r\n" + ab.toString();
        testOutput.reset();
        String result2 = "There were no entries were found in the address book" +
                " for a last name starting with " + "\"" + input2 + "\"\r\n";
        String result3 = "The following 1 entries were found in the address book" +
                " for a last name starting with " + "\"" + input3 + "\"\r\n" + "1: " + ae1 + "\n\n";
        String result4 = "The following 2 entries were found in the address book" +
                " for a last name starting with " + "\"" + input4 + "\"\r\n" + "1: " + ae2 + "\n\n"
                + "2: " + ae3 + "\n\n";

        ab.find(input1);
        assertEquals(result1, testOutput.toString());
        testOutput.reset();

        ab.find(input2);
        assertEquals(result2, testOutput.toString());
        testOutput.reset();

        ab.find(input3);
        assertEquals(result3, testOutput.toString());
        testOutput.reset();

        ab.find(input4);
        assertEquals(result4, testOutput.toString());
        testOutput.reset();
    }

    @Test
    void testClear() {
        ab.add(ae1);
        ab.add(ae2);
        ab.add(ae3);
        ab.clear();
        assertEquals("", ab.toString());
    }

    @Test
    void testToString() {
        //We dont know if add works properly. This test is invalid and shows nothing!!!! For example imagine that add does
        //not work properly so it inputs garbage data. toString does work properly either. In fact it is so bad that it
        //takes garbage and outputs what we expect in an extreme twist of fate. Now we believe that toString works but we
        //have exercised circular reasoning. !!!!!!Garbage!!!!!!! How can I decouple the two. Only one independent variable.
        String expected = "";
        assertEquals(expected, ab.toString());

        ab.add(ae1);
        expected += "1: John A\n   Arroyo\n   Dublin, NY 81777\n   boring@gmail.com\n   925-123-7924\n\n";
        assertEquals(expected, ab.toString());

        expected += "2: John Doe\n   Arroyo\n   Dublin, NY 81777\n   boring@gmail.com\n   925-123-7924\n\n";
        ab.add(ae2);
        assertEquals(expected, ab.toString());

        ab.add(ae3);
        expected += "3: John Dof\n   Arroyo\n   Dublin, NY 81777\n   boring@gmail.com\n   925-123-7924\n\n";
        assertEquals(expected, ab.toString());
    }

}