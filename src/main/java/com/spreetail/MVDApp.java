package com.spreetail;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import static com.spreetail.MultiValueDictIO.*;

/**
 * This is a simple implementation of a Multi value Dictionary App.
 * 
 * @author Jordan M. Schall
 *
 */
public class MVDApp {

    public static MultiValueDict mvd = new MultiValueDictImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    	try {
        String line = "";
        MultiValueDictIO.output("****Welcome to the Multi-Value Dictionary terminal app****");
        MultiValueDictIO.output("To see a list of available commands simply press enter");
        MultiValueDictIO.output("To exit simply type exit and hit enter");
        while (!line.equalsIgnoreCase("exit")) {
            line = scanner.nextLine();
            List<String> input = Arrays.asList(line.split(" "));
            String operation = input.get(0);
            mapOperation(operation, input);
        }
    	} catch ( Exception e) {
    		MultiValueDictIO.output("Unhandled Exception, stopping applicaiton");
    	} finally {
    		scanner.close();
    	}
        

    }

    public static void mapOperation(String operation, List<String> input) {
        if (operation == null || operation.isEmpty() )
            logAvailableCommands();
        else
            switch(operation.toUpperCase()){
                case "KEYS":
                    logKeys(mvd, input);
                    break;
                case "MEMBERS":
                    logMembers(mvd, input);
                    break;
                case "ADD":
                    logAdd(mvd, input);
                    break;
                case "REMOVE":
                    logRemove(mvd, input);
                    break;
                case "REMOVEALL":
                    logRemoveAll(mvd,input);
                    break;
                case "CLEAR":
                    logClear(mvd,input);
                    break;
                case "KEYEXISTS":
                    logKeyExists(mvd, input);
                    break;
                case "MEMBEREXISTS":
                    logMemberExist(mvd, input);
                    break;
                case "ALLMEMBERS":
                    logAllMembers(mvd, input);
                    break;
                case "ITEMS":
                    logItems(mvd, input);
                    break;
                default:
                    logHelp();
            }
    }
}
