package com.google.challenges;

import java.util.Arrays;
import java.util.ArrayList;

public class Answer {
    public static ArrayList<String> ids = new ArrayList<>();
    public static int answer(String n, int b) {

        // Your code goes here.
        ids.add(n);
        int k = n.length();
        int asc = Integer.parseInt(sort(n, false), b);
        int desc = Integer.parseInt(sort(n, true), b);
        String next = calc(asc, desc, b, k);
        
        if (ids.contains(next)) {
        	return ids.size() - ids.indexOf(next);
        } else {
        	return answer(next, b);
        }

    }
    
    public static String calc(int asc, int desc, int b, int k) {
    	int next = desc - asc;
    	String id = new String("");
    	while (next != 0) {
    		id = (next % b) + id;
    		next = Math.floorDiv(next, b);
    	}
    	
    	return padding(id, k);
    }
    
    public static String padding(String n, int l) {
    	while (n.length() < l) {
    		n = '0' + n;
    	}
    	return n;
    }
    
    public static String sort(String n, boolean desc) {
    	String result = new String("");
    	String[] split = n.split(result);
    	int[] splitNumbers = new int[split.length];
    	for (int i = 0; i < split.length; i++) {
    		splitNumbers[i] = Integer.parseInt(split[i]);
    	}
    	Arrays.sort(splitNumbers);
    	for (int i = 0; i < split.length; i++) {
    		result = (desc) ? splitNumbers[i] + result : result + splitNumbers[i];
    	}
    	return result;
    }
}