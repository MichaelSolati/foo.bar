package com.google.challenges;

import java.util.ArrayList;
import java.util.Arrays;


public class Answer {
  public static String answer(String chunk, String word) {

    // Your code goes here.
    ArrayList<String> resultsLis = new ArrayList<String>();
    int offset = chunk.length()-word.length();

    for (int i = 0; i < offset; i++) {
      String result = removalProcess(chunk, word, i);
      if (result != chunk) {
        resultsLis.add(result);
      }
    }

    String[] resultsStr = resultsLis.toArray(new String[resultsLis.size()]);
    Arrays.sort(resultsStr);

    return resultsStr[0];
  }

  private static String removalProcess(String chunk, String word, int offset) {
    String subject = chunk;
    String search = word;
    int index = subject.indexOf(search, offset);
    int length = search.length();

    while (index != -1 && offset < length) {
      subject = removeSubstring(subject, index, length);
      index = subject.indexOf(search);
    }

    return subject;
  }

  private static String removeSubstring(String string, int start, int length) {
    int a = start;
    int b = start + length;
    return (string.substring(0,a) + string.substring(b,string.length()));
  }
}
