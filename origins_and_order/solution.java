package com.google.challenges;

import java.text.*;
import java.util.*;

public class Answer {
  public static String answer(int x, int y, int z) {
    int possibleDates = 0;
    int[][] inputs = {{x, y, z}, {x, z, y}, {y, x, z}, {y, z, x}, {z, x, y}, {z, y, x}};
    String dateString = null;
    String solution = null;
    ArrayList<String> solutionList = new ArrayList<String>();

    for (int i = 0; i < 6; i++) {
      if (!monthDayCheck(inputs[i][0], inputs[i][1])) {
        dateString = dateStringBuilder(inputs[i]);
        try {
          DateFormat inputFormatter = new SimpleDateFormat("MM-dd-yy");
          DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yy");
          Date startDate = (Date) inputFormatter.parse(dateString);
          solution = outputFormatter.format(startDate);
          if (!checkSolutions(solutionList, solution)) {
            possibleDates++;
          }
          solutionList.add(solution);
        } catch (Exception e) {
        }
      }
    }

    if (possibleDates != 1){
      return "Ambiguous";
    }
    return solution;
  }

  private static boolean monthDayCheck (int mm, int dd) {
    if (mm > 12) {
      return true;
    } else if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12) {
      if (dd > 31) {
        return true;
      }
    } else if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
      if (dd > 30) {
        return true;
      }
    } else if (mm == 2) {
      if (dd > 28) {
        return true;
      }
    } else {
      return true;
    }
    return false;
  }

  private static String dateStringBuilder (int[] arrayInput) {
    String dateString = "";
    for (int o = 0; o < arrayInput.length; o++){
      if (arrayInput[o] < 10) {
        dateString += "0"+arrayInput[o];
      } else {
        dateString += Integer.toString(arrayInput[o]);
      }
      if (o < 2) {
        dateString += "-";
      }
    }
    return dateString;
  }

  public static boolean checkSolutions(ArrayList<String> solutionList, String solution) {
    return solutionList.contains(solution);
  }
}
