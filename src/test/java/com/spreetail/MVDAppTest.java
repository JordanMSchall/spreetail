package com.spreetail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


import static org.junit.Assert.*;

/**
 * This class holds all unit tests based on current requirements. 
 * 
 * @author Jordan M. Schall
 *
 */
public class MVDAppTest {
    private MultiValueDict mvd;

    @Before
    public void setup() throws MultiValueDictException {
        this.mvd = new MultiValueDictImpl();
    }

    @After
    public void tearDown() {
        this.mvd = new MultiValueDictImpl();
    }

    private Set<String> addTestKeys() throws MultiValueDictException {
        Set<String> keys = new HashSet<String>();
        keys.add("key1");
        keys.add("key2");
        for (String key : keys)
            this.mvd.addEntry(key, "defaultMember");
        return keys;
    }


    private Set<String> addTestMembers(Set<String> keys) throws MultiValueDictException {
        Set<String> members = new HashSet<String>();
        members.add("member1");
        members.add("member2");
        for (String key : keys)
            for (String member : members)
                mvd.addEntry(key, member);

        members.add("defaultMember");
        return members;
    }


    // Returns all the keys in the dictionary.
    // Order is not guaranteed.
    @Test
    public void shouldGetKeys() {
        Set<String> expectedKeys = null;
        try {
            expectedKeys = addTestKeys();
            assertTrue(expectedKeys.equals(mvd.getKeys()));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Returns the collection of strings for the given key. Return order is not guaranteed.
    // Returns an error if the key does not exists.
    @Test
    public void shouldGetMembers() {
        Set<String> expectedKeys = null;
        Set<String> expectedMembers = null;
        try {
            expectedKeys = addTestKeys();
            expectedMembers = addTestMembers(expectedKeys);
            for (String key : expectedKeys)
                assertTrue(expectedMembers.equals(mvd.getMembers(key)));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Adds a member to a collection for a given key. Displays an error if the member already exists for the key.
    @Test
    public void shouldAddEntry() {
        String key = "testKey";
        String member = "testMember";
        try {
            mvd.addEntry(key, member);
            assertTrue(mvd.keyExists(key));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Removes a member from a key. If the last member is removed from the key,
    // the key is removed from the dictionary. If the key or member does not exist, displays an
    //error
    @Test
    public void shouldRemoveMember() {
        String testKey = "testKey";
        String testMember = "testMember1";
        String testMember2 = "testMember2";

        try {
            mvd.addEntry(testKey, testMember);
            mvd.addEntry(testKey, testMember2);
            mvd.removeMember(testKey, testMember);
            assertFalse(mvd.memberExists(testKey, testMember));
            assertTrue(mvd.memberExists(testKey, testMember2));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Removes all members for a key and removes the key from the dictionary.
    // Returns an error if the key does not exist.
    @Test
    public void shouldRemoveAll() {

        String testKey = "testKey";
        String testMember = "testMember";
        try {
            mvd.addEntry(testKey, testMember);
            mvd.removeAll(testKey);
            assertFalse(mvd.keyExists(testKey));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Removes all keys and all members from the dictionary.
    @Test
    public void shouldBeClear() {
        String testKey = "testKey";
        String testMember = "testMember";
        try {
            mvd.addEntry(testKey, testMember);
            mvd.clear();
            assertFalse(mvd.keyExists(testKey));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Returns whether a key exists or not.
    @Test
    public void keyShouldExist() {
        Set<String> expectedKeys = null;
        try {
            expectedKeys = addTestKeys();
            for (String key : expectedKeys)
                assertTrue(mvd.keyExists(key));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Returns whether a member exists within a key. Returns false if the key does not exist.
    @Test
    public void membersShouldExist() {
        Set<String> expectedKeys = null;
        Set<String> expectedMembers = null;
        try {
            expectedKeys = addTestKeys();
            expectedMembers = addTestMembers(expectedKeys);
            for (String key : expectedKeys)
                for (String member : expectedMembers)
                    assertTrue(mvd.memberExists(key, member));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Returns all the members in the dictionary. Returns nothing if there are none. Order is not guaranteed.
    @Test
    public void shouldGetAllMembers() {
        Set<String> expectedKeys = null;
        Set<String> expectedMembers = null;
        try {
            expectedKeys = addTestKeys();
            expectedMembers = addTestMembers(expectedKeys);
            assertEquals(expectedMembers, mvd.getAllMembers());
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Returns all keys in the dictionary and all of their members. Returns nothing if there are none. Order is not guaranteed.
    @Test
    public void shouldGetAllItems() {
        Set<String> expectedKeys = null;
        Set<String> expectedMembers = null;
        Set<String> items = new HashSet<String>();

        try {
            expectedKeys = addTestKeys();
            expectedMembers = addTestMembers(expectedKeys);
            for (String key : expectedKeys)
                for (String member : expectedMembers)
                    items.add(key + ": " + member);

            assertTrue(items.equals(mvd.getAllItems()));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }
}
