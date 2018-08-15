package com.google.challenges;

import java.util.ArrayList;

public class Answer {   
    public static int[] answer(int area) { 

        // Your code goes here.
        ArrayList<Integer> squaresList = new ArrayList<>();

        while (area > 0) {
          int a = (int) Math.pow(Math.floor(Math.sqrt(area)), 2);
          area -= a;
          squaresList.add(a);
        }

        int[] squares = new int[squaresList.size()];

        for (int i = 0; i < squaresList.size(); i++) {
          squares[i] = squaresList.get(i);
      }
        
        return squares;
    } 
}