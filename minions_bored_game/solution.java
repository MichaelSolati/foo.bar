package com.google.challenges;
import java.util.*;

public class Answer {
  public static int moduLOL = 123454321;
  static int t;
  static int n;

  public static int answer(int t, int n) {
    Answer.t = t;
    Answer.n = n;
    HashMap<String, Integer> games = new HashMap<>();

    return letsPlayAGame(t, 1, games);
  }

  public static int letsPlayAGame(int rolls, int position, HashMap<String, Integer> games) {
    String game = rolls+","+position;

    if (position == n) {
      return 1;
    } else if (((position + rolls) < n) || (rolls == 0)) {
      return 0;
    } else if (games.containsKey(game)) {
      return games.get(game);
    }

    int results = 0;

    // Go Left
    if (position > 1 && position != t) {
      results += letsPlayAGame(rolls-1, position-1, games);
    }

    results += letsPlayAGame(rolls-1, position, games);

    // Go Right
    if (position < n) {
      results += letsPlayAGame(rolls-1, position+1, games);
    }

    results %= moduLOL;
    games.put(game, results);
    return results%moduLOL;
  }
}
