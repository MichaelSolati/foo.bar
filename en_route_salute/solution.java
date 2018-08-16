package com.google.challenges; 

public class Answer {   
    public static int answer(String s) { 

        // Your code goes here.
        int instances = 0;
        while (s.indexOf('>') != -1) {
          int index = s.indexOf('>');
          String sub = s.substring(index + 1);
          instances += (charCount(sub) * 2);
          s = s.substring(0, index) + s.substring(index + 1);
        }
        return instances;
    } 

    public static int charCount(String s) {
      int count = 0;
      for (char ch: s.toCharArray()) {
        count += (ch == '<') ? 1 : 0;
      }
      return count;
    }
}