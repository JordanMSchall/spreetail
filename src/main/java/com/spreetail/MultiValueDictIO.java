package com.spreetail;

import java.util.ArrayList;
import java.util.List;

public class MultiValueDictIO {

    public static void logKeys(MultiValueDict mvd, List<?> input) {
        if(mvd.getKeys() == null || mvd.getKeys().isEmpty()) {
            output("Empty Set");
            return;
        }
        for (String key : mvd.getKeys())
            output(key);
    }

    public static void logMembers(MultiValueDict mvd, List<String> input) {
        if(mvd.getKeys() == null || mvd.getKeys().isEmpty()) {
            output("Empty Set");
            return;
        }
        try {
            String key = input.get(1);
            for (String member : mvd.getMembers(key))
                output(member);
        } catch (MultiValueDictException e) {
            output(e.getMessage());
        }
    }

    public static void logAdd(MultiValueDict mvd, List<String> input) {
        if (input.size() < 3) {
            output("Not enough args.");
            return;
        }
        try {
            String key = input.get(1);
            String member = input.get(2);
            mvd.addEntry(key, member);
            output("added");
        } catch (MultiValueDictException e) {
            output(e.getMessage());
        }
    }

    public static void logRemove(MultiValueDict mvd, List<String> input) {
        if (input.size() < 3) {
            output("Not enough args.");
            return;
        }
        try {
            String key = input.get(1);
            String member = input.get(2);
            mvd.removeMember(key, member);
            output("removed");
        } catch (MultiValueDictException e) {

        }
    }

    public static void logRemoveAll(MultiValueDict mvd, List<String> input) {
        if (input.size() < 2) {
            output("Not enough args.");
            return;
        }
        try {
            String key = input.get(1);
            mvd.removeAll(key);
            output("removed");
        } catch (MultiValueDictException e) {
            output(e.getMessage());
        }
    }

    public static void logKeyExists(MultiValueDict mvd, List<String> input) {
        if (input.size() < 2) {
            output("Not enough args.");
            return;
        }
        String key = input.get(1);
        String outputS = mvd.keyExists(key) ? "true" : "false";
        output(outputS);
    }


    public static void logItems(MultiValueDict mvd, List<String> input) {
        for( String item: (List<String>)mvd.getAllItems()){
            output(item);
        };
    }

    public static void logAllMembers(MultiValueDict mvd, List<String> input) {
        if(mvd.getKeys() == null || mvd.getKeys().isEmpty()) {
            output("Empty Set");
            return;
        }
        for (String member: mvd.getAllMembers())
            output(member);
    }

    public static void logMemberExist(MultiValueDict mvd, List<String> input) {
        if (input.size() < 3) {
            output("Not enough args.");
            return;
        }
        String key = input.get(1);
        String member = input.get(2);
        String outputS = mvd.memberExists(key, member) ? "true" : "false";
        output(outputS);
    }

    public static void logClear(MultiValueDict mvd, List<String> input) {
        mvd.clear();
        output("cleared");
    }

    public static void logHelp() {
        output("****That is not a recognized entry****");
        output("****Please hit enter to see a list of available commands****");

    }

    public static void logAvailableCommands() {
        output("Available Commands are: ");
        output("KEYS");
        output("MEMBERS <key>");
        output("ADD <key> <member>");
        output("REMOVE <key> <member>");
        output("REMOVEALL <key>");
        output("CLEAR");
        output("KEYEXISTS <key>");
        output("MEMBEREXISTS <key> <member>");
        output("ALLMEMBERS");
        output("ITEMS");
    }

    protected static void output(String message) {
        System.out.println(message);
    }

}
