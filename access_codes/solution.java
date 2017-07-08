package com.google.challenges;

import java.util.ArrayList;

public class Answer {
  public static int answer(String[] x) {

    // Your code goes here.

    ArrayList<String> possibleCodes = new ArrayList<String>();
    for (int i = 0; i < x.length; i++) {
      String code = x[i];
      String reverseCode = new StringBuffer(code).reverse().toString();
      if (!possibleCodes.contains(code)) {
        if (!possibleCodes.contains(reverseCode)) {
          possibleCodes.add(code);
        }
      }
    }

    String[] codes = possibleCodes.toArray(new String[possibleCodes.size()]);

    return codes.length;
  }
}
