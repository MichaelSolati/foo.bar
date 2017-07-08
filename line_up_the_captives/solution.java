package com.google.challenges;

public class Answer {
  public static String answer(int x, int y, int n) {

    // Your code goes here.
    double acc = 0;
    for (int i = 1; i <= n; i++) {
      acc += comb(n-1, i-1) * permutations(i-1, x-1) * permutations(n-i, y-1);
    }
    return Integer.toString((int) acc);
  }

  private static double permutations(double rabbits, double seen) {
    double acc = 0;
    if (rabbits < seen) {
      return 0;
    } else if (rabbits == seen) {
      return 1;
    } else {
      for (double i = 1; i <= rabbits; i++) {
        acc += comb(rabbits-1, i-1) * permutations(i-1, seen-1) * factorial(rabbits-i);
      }
      return acc;
    }
  }

  private static double comb(double n, double k) {
    return factorial(n) / (factorial(k) * factorial(n-k));
  }

  private static double factorial(double n) {
    int acc = 1;
    for (double i = 1; i <= n; i++) {
      acc *= i;
    }
    return acc;
  }
}
