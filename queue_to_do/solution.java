package com.google.challenges; 

public class Answer {   
    public static int answer(int start, int length) { 

        // Your code goes here.
        int result = 0;
        int backCount = length;

        for (int x = 0; x < length; x++) {
          for (int y = 0; y < backCount; y++) {
            int val = start + y + (x * (length + 1)) - x;
            result = (x == 0 && y == 0) ? val : (result ^ val);
          }
          backCount--;
        }

        return result;
    } 
}