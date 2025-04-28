package com.example.phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    void testAddSingleContact() {
        int count = phoneBook.add("Alice", "1234567890");
        assertEquals(1, count, "Adding one contact should return 1");
    }

    @Test
    void testAddTwoDifferentContacts() {
        phoneBook.add("Alice", "1234567890");
        int count = phoneBook.add("Bob", "0987654321");
        assertEquals(2, count, "Adding two contacts should return 2");
    }

    @Test
    void testAddDuplicateName() {
        phoneBook.add("Alice", "1234567890");
        int count = phoneBook.add("Alice", "0987654321");
        assertEquals(1, count, "Adding duplicate name should not increase count");
    }

    @Test
    void testFindByNumberExisting() {
        phoneBook.add("Alice", "1234567890");
        String name = phoneBook.findByNumber("1234567890");
        assertEquals("Alice", name, "Should find name by number");
    }

    @Test
    void testFindByNumberNonExisting() {
        phoneBook.add("Alice", "1234567890");
        String name = phoneBook.findByNumber("0987654321");
        assertNull(name, "Should return null for non-existing number");
    }
}