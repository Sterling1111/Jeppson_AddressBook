package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    private final AddressBook ab = new AddressBook();

    /**
     * Test method for {@link AddressBook#list()}.
     */
    @Test
    void testList() {
        AddressBook ab = new AddressBook();
        String expected = "";
        assertEquals(expected, ab.toString());
    }

    /**
     * Test method for {@link AddressBook#remove(java.lang.String)}
     */
    @Test
    void testRemove1() {
        AddressBook ab = new AddressBook();

    }

    @Test
    void testAdd() {
    }

    @Test
    void testReadFromFile() {
    }

    @Test
    void testFind() {
    }

    @Test
    void testClear() {
    }

    @Test
    void testToString() {
    }


}