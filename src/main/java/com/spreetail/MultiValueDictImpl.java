package com.spreetail;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MultiValueDictImpl implements MultiValueDict{
    private HashMap<String, Set<String>> mvd;


    @Override
    public List<String> getKeys() {
        return null;
    }

    @Override
    public List<String> getMembers(String key) throws MultiValueDictException {
        return null;
    }

    @Override
    public void addEntry(String key, String member) throws MultiValueDictException {

    }

    @Override
    public void removeMember(String key, String member) throws MultiValueDictException {

    }

    @Override
    public void removeAll(String key) throws MultiValueDictException {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean keyExists(String key) {
        return false;
    }

    @Override
    public boolean memberExists(String key, String member) {
        return false;
    }

    @Override
    public List<String> getAllMembers() {
        return null;
    }

    @Override
    public List<?> getAllItems() {
        return null;
    }
}
