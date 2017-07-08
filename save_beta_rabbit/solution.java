package com.google.challenges;

import java.util.*;

public class Answer {

  public static int answer(int food, int[][] grid) {
    int n = grid[0].length;
    List<List<Set<Integer>>> consumption = new ArrayList<>();

    for (int row = 0; row < n; row++) {
      List<Set<Integer>> consumptionRow = new ArrayList<>();
      consumption.add(consumptionRow);

      for (int col = 0; col < n; col++) {
        int hunger = grid[row][col];

        Set<Integer> foodUsedHere = new HashSet<>();

        if (row != 0) {
          for (int i : consumption.get(row - 1).get(col)) {
            foodUsedHere.add(i + hunger);
          }
        }

        if (col != 0) {
          for (int i : consumption.get(row).get(col - 1)) {
            foodUsedHere.add(i + hunger);
          }
        }

        // First Room
        if (foodUsedHere.size() == 0) {
          foodUsedHere.add(0);
        }

        consumptionRow.add(foodUsedHere);
      }
    }

    ArrayList<Integer> foodRequiredLis = new ArrayList<>(consumption.get(n - 1).get(n - 1));
    Integer[] foodRequiredInt = foodRequiredLis.toArray(new Integer[foodRequiredLis.size()]);
    Arrays.sort(foodRequiredInt);

    int foodNeeded = -1;
    for (int i = 0; i < foodRequiredInt.length; i++) {
      if (foodRequiredInt[i] <= food) {
        foodNeeded = foodRequiredInt[i];
      } else {
        if (foodNeeded == -1) {
          return -1;
        }
      }
    }

    return food - foodNeeded;
  }
}
