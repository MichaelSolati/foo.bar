package com.google.challenges;

public class Answer {
  public static int[] answer(int[][] minions) {

    // Your code goes here.
    double[] probability = new double[minions.length];
    int[] result = new int[minions.length];

    for (int i = 0; i < minions.length; i++) {
      double time = minions[i][0];
      double numerator = minions[i][1];
      double denomenator = minions[i][2];
      double fraction = (numerator / denomenator);
      probability[i] = (time / fraction);
      result[i] = i;
    }

    result = BubbleSort(probability, result);

    return result;
  }


  private static int[] BubbleSort(double[] probability, int[] result) {
    boolean flag = true;
    double tempP;
    int tempI;

    while (flag) {
      flag = false;
      for (int i = 0; i < probability.length - 1; i++) {
        if (probability[i] > probability[i + 1]) {
          tempP = probability[i];
          tempI = result[i];

          probability[i] = probability[i + 1];
          probability[i + 1] = tempP;

          result[i] = result[i + 1];
          result[i + 1] = tempI;
          flag = true;
        }
      }
    }

    return result;
  }
}
