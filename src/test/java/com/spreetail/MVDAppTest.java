package com.spreetail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple MVDApp.
 */
public class MVDAppTest {
    private MultiValueDict mvd;

    @Before
    public void setup() throws MultiValueDictException {
        mvd = new MultiValueDictImpl();
    }

    @After
    private void tearDown() {
        this.mvd = null;
    }

    private List<String> addTestKeys() throws MultiValueDictException {
        List<String> keys = new ArrayList<String>();
        keys.add("key1");
        keys.add("key2");
        for (String key : keys)
            this.mvd.addEntry(key, null);
        return keys;
    }


    private List<String> addTestMembers(List<String> keys) throws MultiValueDictException {
        List<String> members = new ArrayList<String>();
        keys.add("member1");
        keys.add("member2");
        for (String key : keys)
            for (String member : members)
                this.mvd.addEntry(key, member);
        return members;
    }


    // Returns all the keys in the dictionary.
    // Order is not guaranteed.
    @Test
    public void shouldGetKeys() {
        List<String> expectedKeys = null;
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
        List<String> expectedKeys = null;
        List<String> expectedMembers = null;
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
        List<String> expectedKeys = null;
        List<String> expectedMembers = null;
        try {
            expectedKeys = addTestKeys();
            expectedMembers = addTestMembers(expectedKeys);
            mvd.removeMember(expectedKeys.get(0), expectedMembers.get(0));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Removes all members for a key and removes the key from the dictionary.
    // Returns an error if the key does not exist.
    @Test
    public void shouldRemoveAll() {
        List<String> expectedKeys = null;
        List<String> expectedMembers = null;
        try {
            expectedKeys = addTestKeys();
            expectedMembers = addTestMembers(expectedKeys);
            mvd.removeAll(expectedKeys.get(0));
            assertFalse(mvd.keyExists(expectedKeys.get(0)));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Removes all keys and all members from the dictionary.
    @Test
    public void shouldBeClear() {
        List<String> expectedKeys = null;
        List<String> expectedMembers = null;
        try {
            expectedKeys = addTestKeys();
            expectedMembers = addTestMembers(expectedKeys);
            mvd.clear();
            assertFalse(mvd.keyExists(expectedKeys.get(0)));
        } catch (MultiValueDictException e) {
            assertTrue(false);
        }
    }

    // Returns whether a key exists or not.
    @Test
    public void keyShouldExist() {
        List<String> expectedKeys = null;
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
        List<String> expectedKeys = null;
        List<String> expectedMembers = null;
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
        List<String> expectedKeys = null;
        List<String> expectedMembers = null;
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
    public void getAllItems() {
        List<String> expectedKeys = null;
        List<String> expectedMembers = null;
        List<String> items = new ArrayList<String>();
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
