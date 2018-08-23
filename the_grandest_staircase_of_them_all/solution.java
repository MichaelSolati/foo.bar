package com.google.challenges;

public class Answer {
	public static int answer(int n) {

		// Your code goes here.

		int plusOne = n + 1;
		int[][] stairs = new int[plusOne][plusOne];
		stairs[1][1] = stairs[2][2] = 1;
		for (int x = 3; x < n + 1; x++) {
			for (int y = 1; y <= x; y++) {
				if (x - y == 0) {
					stairs[x][y] = 1 + stairs[x][y - 1];
				} else if (x - y < y) {
					stairs[x][y] = stairs[x - y][x - y] + stairs[x][y - 1];
				} else if (x - y == y) {
					stairs[x][y] = stairs[y][y - 1] + stairs[x][y - 1];
				} else if (x - y > y) {
					stairs[x][y] = stairs[x - y][y - 1] + stairs[x][y - 1];
				}
			}
		}
		return stairs[n][n] - 1;
	}
}
