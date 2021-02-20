package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest {

    @Test
    void testToString() {
        AddressEntry ae = new AddressEntry("John", "Doe", "street", "city", "state", 12345,
                                           "email@gmail.com", "123-456-7891");
        String expected = "John Doe\n   street\n   city, state 12345\n   email@gmail.com\n   123-456-7891";
        assertEquals(expected, ae.toString());
    }

    @Test
    void testCompareTo() {
        AddressEntry ae1 = new AddressEntry("John", "Doe", "street", "city", "state", 12345,
                "email@gmail.com", "123-456-7891");

        AddressEntry ae2 = new AddressEntry("John", "Doe", "street", "city", "state", 12345,
                "email@gmail.com", "123-456-7891");

        AddressEntry ae3 = new AddressEntry("John", "Dof", "street", "city", "state", 12345,
                "email@gmail.com", "123-456-7891");

        AddressEntry ae4 = new AddressEntry("John", "A", "street", "city", "state", 12345,
                "email@gmail.com", "123-456-7891");

        assertTrue(ae1.compareTo(ae2) == 0);
        assertTrue(ae1.compareTo(ae3) < 0);
        assertTrue(ae1.compareTo(ae4) > 0);
    }

    @Test
    void testGetSet() {
        AddressEntry ae = new AddressEntry();
        ae.setFirstName("John");
        ae.setLastName("Purcell");
        ae.setCity("Livermore");
        ae.setState("HI");
        ae.setZip(12345);
        ae.setStreet("Singletree");
        ae.setEmail("fake@yahoo.com");
        ae.setPhone("123-456-7891");

        assertEquals("John", ae.getFirstName());
        assertEquals("Purcell", ae.getLastName());
        assertEquals("Livermore", ae.getCity());
        assertEquals("HI", ae.getState());
        assertEquals(12345, ae.getZip());
        assertEquals("Singletree", ae.getStreet());
        assertEquals("fake@yahoo.com", ae.getEmail());
        assertEquals("123-456-7891", ae.getPhone());
    }
}