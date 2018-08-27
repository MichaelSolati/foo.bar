package com.google.challenges;

import java.util.*;

public class Answer {
	public static int[] answer(int[][] m) {

		// Your code goes here.
			
		int xLength = m.length;
		int yLength = m[0].length;
		ArrayList<Integer> absorbed = new ArrayList<Integer>();

		double[][] a = new double[xLength][yLength];
		for (int x = 0; x < xLength; x++) {
			double sum = 0;
			for (int y = 0; y < yLength; y++) {
				a[x][y] = m[x][y];
				sum += a[x][y];
			}
			if (sum > 0) {
				for (int y = 0; y < yLength; y++) {
					a[x][y] /= sum;
				}
			} else if (sum == 0) {
				a[x][x] = 1;
				absorbed.add(x);
			}

		}
		double[][] power = power(a, 1000);
		double[] initial = new double[xLength];
		initial[0] = 1.0;

		double[][] solutions = multiply(new double[][] { initial }, power);
		double[] solution = solutions[0];
		int[] denominators = new int[absorbed.size()];
		Fraction[] absorbedRows = new Fraction[absorbed.size()];
		
		for (int i = 0; i < absorbed.size(); i++) {
			absorbedRows[i] = simplify(solution[absorbed.get(i)]);
		}
		for (int i = 0; i < absorbedRows.length; i++) {
			denominators[i] = absorbedRows[i].denominator;
		}

		int lcm = lcm(denominators);

		int[] result = new int[absorbedRows.length + 1];
		result[result.length - 1] = lcm;
		for (int i = 0; i < absorbedRows.length; i++) {
			Fraction fraction = absorbedRows[i];
			result[i] = (fraction.denominator != 0) ? (lcm / fraction.denominator) * fraction.numerator : 0;
		}

		return result;
	}



	public static int denominator(int numerator, int low, int high, double value) {
		if (Math.abs(high - low) <= 1) {
			double m = low;
			double n = numerator;
			double roundeded = round((n / m));
			if (Math.abs(roundeded - value) < 0.00001) return low;
			m = high;
			n = numerator;
			roundeded = round((n / m));
			if (Math.abs(roundeded - value) < 0.00001) return high;
			return -1;
		}

		int mid = (low + high) / 2;
		double m = mid;
		double n = numerator;
		double roundeded = round((n / m));
		
		if (Math.abs(roundeded - value) < 0.00001) {
			return mid;
		} else if (roundeded < value) {
			return denominator(numerator, low, mid, value);
		} else {
			return denominator(numerator, mid, high, value);
		}
	}
	
	public static int lcm(int a, int b) {
		int gcd = Fraction.gcd(a, b);
		return (gcd != 0) ? (a * (b / gcd)) : 0;
	}
	
	public static int lcm(int[] a) {
		if (a.length == 0) return 0;
		int result = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > 0)
				result = lcm(result, a[i]);
		}
		return result;
	}

	public static double[][] multiply(double[][] a, double[][] b) {
		int aXLength = a.length;
		int aYLength = a[0].length;
		int bYLength = b[0].length;
		double[][] result = new double[aXLength][bYLength];

		for (int x = 0; x < aXLength; x++) {
			for (int y = 0; y < bYLength; y++) {
				for (int z = 0; z < aYLength; z++) {
					result[x][y] = round(result[x][y] + round(a[x][z] * b[z][y]));
				}
			}
		}
		
		return result;
	}
	
	public static double[][] power(double[][] a, int power) {
		if (power <= 1) return a;
		double[][] r = power(a, power / 2);
		double[][] m = multiply(r, r);
		return (power % 2 != 0) ? multiply(m, a) : m;
	}
	
	public static double round(double value) {
		long factor = (long) Math.pow(10, 10);
		value *= factor;
		double tmp = Math.round(value);
		return tmp / factor;
	}

	public static Fraction simplify(double d) {
		if (d < 0.0001) return new Fraction(0, 1);
		int range = 1000;
		double rounded = round(d);
		for (int numerator = 1; numerator < range; numerator++) {
			int denominator = denominator(numerator, 1, range, rounded);
			if (denominator > 0) {
				Fraction f = new Fraction(numerator, denominator);
				return f;
			}
		}
		return null;
	}


	public static class Fraction {
		public int numerator;
		public int denominator;

		public Fraction(int n, int d) {
			numerator = n;
			denominator = d;
		}

		public static int gcd(int a, int b) {
			return (b == 0) ? a : gcd(b, a % b);
		}
	}

}