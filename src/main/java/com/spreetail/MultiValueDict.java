package com.spreetail;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface MultiValueDict {

    // Returns all the keys in the dictionary.
    // Order is not guaranteed.
    public List<String> getKeys();

    // Returns the collection of strings for the given key. Return order is not guaranteed.
    // Returns an error if the key does not exists.
    public List<String> getMembers(String key) throws MultiValueDictException;

    // Adds a member to a collection for a given key. Displays an error if the member already exists for the key.
    public void addEntry(String key, String member) throws MultiValueDictException;;

    // Removes a member from a key. If the last member is removed from the key,
    // the key is removed from the dictionary. If the key or member does not exist, displays an
    //error
    public void removeMember(String key, String member) throws MultiValueDictException;;

    // Removes all members for a key and removes the key from the dictionary.
    // Returns an error if the key does not exist.
    public void removeAll(String key) throws MultiValueDictException;;

    // Removes all keys and all members from the dictionary.
    public void clear();

    // Returns whether a key exists or not.
    public boolean keyExist(String key);

    // Returns whether a member exists within a key. Returns false if the key does not exist.
    public boolean memberExists(String key);

    // Returns all the members in the dictionary. Returns nothing if there are none. Order is not guaranteed.
    public List<String> getAllMembers();

    // Returns all keys in the dictionary and all of their members. Returns nothing if there are none. Order is not guaranteed.
    public List<?> getAllItems();

    https://github.com/JordanMSchall/spreetail/
}
