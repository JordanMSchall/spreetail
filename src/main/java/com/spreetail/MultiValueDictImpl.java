package com.spreetail;

import java.util.HashMap;
import java.util.Set;

public class MultiValueDictImpl implements MultiValueDict{
    private HashMap<String, Set<String>> mvd;

    public MultiValueDictImpl() {
        this.mvd = new HashMap<String, Set<String>>();
    }

    public MultiValueDictImpl(HashMap<String, Set<String>> mvd) {
        this.mvd = mvd;
    }

    public void addEntry(String setKey, String member) {

    }

    public void removeMember(String setKey, String member) {

    }

    public void removeAll(String setKey) {

    }

    public void listMembers(String key) {

    }

    public void listAllMembers() {

    }

    public void listKeys() {

    }

    public boolean checkIfKeyExists(String key) {
        return false;
    }

    public boolean checkIfMemberExists(String key) {
        return false;
    }

    @Override
    public String toString() {
        return "MVD{" +
                "mvd=" + mvd.toString() +
                '}';
    }
}
