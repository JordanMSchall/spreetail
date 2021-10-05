package com.spreetail;

import java.util.*;
/**
 * This class is a HashMap<String, Set<String>> implementation of a Multi Value Dictionary.
 * 
 * @author Jordan M. Schall
 *
 */
public class MultiValueDictImpl implements MultiValueDict {
    private HashMap<String, Set<String>> mvd;

    public MultiValueDictImpl() {
        this.mvd = new HashMap<String, Set<String>>();
    }

    @Override
    public Set<String> getKeys() {
        return  mvd.keySet();
    }

    @Override
    public Set<String> getMembers(String key) throws MultiValueDictException {
        return mvd.get(key);
    }

    @Override
    public void addEntry(String key, String member) throws MultiValueDictException {
        if (key == null)
            throw new MultiValueDictException("Error key must have value");
        if (!mvd.containsKey(key))
            addEntryWhenKeyDoesNotExists(key, member);
        else
            addEntryWhenKeyExists(key, member);
    }

    private void addEntryWhenKeyDoesNotExists(String key, String member) throws MultiValueDictException {
       Set<String> newMemberSet = new HashSet<String>();
        if (member == null)
            throw new MultiValueDictException("Error key must have member value");
        else
            newMemberSet.add(member);
        mvd.put(key, newMemberSet);
    }

    private void addEntryWhenKeyExists(String key, String member) throws MultiValueDictException {
        if (member == null)
            throw new MultiValueDictException("Error key must have member value");
        else if ( mvd.get(key).contains(member) )
            throw new MultiValueDictException("Error non-unique member");
        else
            mvd.get(key).add(member);
    }


    @Override
    public void removeMember(String key, String member) throws MultiValueDictException {
        mvd.get(key).remove(member);
    }

    @Override
    public void removeAll(String key) throws MultiValueDictException {
        mvd.remove(key);
    }

    @Override
    public void clear() {
        mvd.clear();
    }

    @Override
    public boolean keyExists(String key) {
        return mvd.containsKey(key);
    }

    @Override
    public boolean memberExists(String key, String member) {
        return mvd.get(key).contains(member);
    }

    @Override
    public Set<String> getAllMembers() {
        Set<String> members = new HashSet<String>();
        Set<String> keys = mvd.keySet();
        for (String key : keys)
            for (String member : mvd.get(key))
                members.add(member);

        return members;
    }

    @Override
    public Set<String> getAllItems() {
        Set<String> items = new HashSet<String>();
        Set<String> keys = mvd.keySet();
        for (String key : keys)
            for (String member : mvd.get(key))
                items.add(key + ": " + member);
        return items;
    }
}
