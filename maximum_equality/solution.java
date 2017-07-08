package com.google.challenges;

public class Answer {
  public static int answer(int[] x) {

    // Your code goes here.
    int totalBunnies = 0;
    int totalFamilies = x.length;

    for(int i = 0; i < x.length; i++) {
      totalBunnies += x[i];
    }

    if ((totalBunnies % totalFamilies) == 0) {
      return totalFamilies;
    } else {
      return (totalFamilies-1);
    }
  }
}
