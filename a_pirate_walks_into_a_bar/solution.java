package com.google.challenges;

public class Answer {
  public static int answer(int[] numbers) {
    // Your code goes here.
    // First traversal
    int pirateOne = 0;
    int pirateCurrent = numbers[pirateOne];

    // intArr keeps track of amount of iterations before loop occurs
    int[] intArr = new int [5000];
    // boolArr keeps track of point in array
    boolean[] boolArr = new boolean[5000];

    // First traversal has been completed, so mark it as done...
    boolArr[pirateOne] = true;
    increment(intArr, boolArr);

    // Talk to pirates
    while(boolArr[pirateCurrent] != true) {
      if(boolArr[pirateCurrent] != true){
        boolArr[pirateCurrent] = true;
        pirateCurrent = numbers[pirateCurrent];
        increment(intArr, boolArr);
      }
    }
    return intArr[pirateCurrent];
  }

  // Increments trip through pirates
  private static void increment(int[] intArr, boolean[] boolArr) {
    for(int i = 0; i < boolArr.length; i++) {
      if(boolArr[i] == true) {
        intArr[i] += 1;
      }
    }
  }
}
