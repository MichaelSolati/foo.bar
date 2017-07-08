package com.google.challenges;
import java.util.*;
import java.math.*;

public class Answer {
  private static Map<Integer, BigInteger> factorials = new HashMap<Integer, BigInteger>();
  private static Map<List<Integer>,BigInteger> chosen = new HashMap<List<Integer>,BigInteger>();

  public static String answer(int[] seq) {
    Tree master = new Tree(seq[0]);

    for (int i = 1; i < seq.length; i++) {
      master.add(new Tree(seq[i]));
    }

    return orderings(master).toString(); // http://stackoverflow.com/questions/17119116/how-many-ways-can-you-insert-a-series-of-values-into-a-bst-to-form-a-specific-tr
  }

  public static BigInteger choose(int n, int combinations) {
    if (combinations > n) {
      return BigInteger.valueOf(0);
    }

    List<Integer> key = Arrays.asList(n, combinations);

    if (chosen.containsKey(key)) {
      return chosen.get(key);
    }

    BigInteger value = factorial(n).divide(factorial(combinations).multiply(factorial(n - combinations)));
    chosen.put(key, value);
    return value;
  }

  public static BigInteger factorial(int key) {
    if (factorials.containsKey(key)) {
      return factorials.get(key);
    }

    BigInteger value = BigInteger.valueOf(1);
    for (int i = 1; i <= key; i++) {
      value = value.multiply(BigInteger.valueOf(i));
    }
    factorials.put(key, value);
    return value;
  }

  public static BigInteger orderings(Tree tree) {
    if (tree == null) return BigInteger.valueOf(1);

    int left = (tree.left == null) ? 0 : tree.left.count();
    int right = (tree.right == null) ? 0 : tree.right.count();

    return choose(left + right, right).multiply(orderings(tree.left)).multiply(orderings(tree.right));
  }
}

class Tree {
  public int value;
  public Tree left = null;
  public Tree right = null;

  public Tree(int value) {
    this.value = value;
  }

  public void add(Tree tree) {
    if (tree.value < value) {
      if (left == null) {
        left = tree;
      } else {
        left.add(tree);
      }
    } else {
      if (right == null) {
        right = tree;
      } else {
        right.add(tree);
      }
    }
  }

  public int count() {
    int count = 1;
    if (left != null) count += left.count();
    if (right != null) count += right.count();
    return count;
  }
}
