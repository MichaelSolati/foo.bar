package com.google.challenges;

public class Answer {
  public static int answer(int[][] vertices) {
    // Your code goes here.
    int result = 0;
    Triangle triangle = new Triangle(vertices);
    int area = triangle.area();

    if (area > 0) {
      result = area - boundaryCount(triangle);
    }

    return result;
  }

  private static int boundaryCount(Triangle triangle) {
    int points = 0;
    int x1 = triangle.point1().x();
    int x2 = triangle.point2().x();
    int x3 = triangle.point3().x();
    int y1 = triangle.point1().y();
    int y2 = triangle.point2().y();
    int y3 = triangle.point3().y();

    points += getGCD(Math.abs(x1 - x2), Math.abs(y1 - y2));
    points += getGCD(Math.abs(x2 - x3), Math.abs(y2 - y3));
    points += getGCD(Math.abs(x3 - x1), Math.abs(y3 - y1));

    return points/2-1;
  }

  private static int getGCD(int a, int b) {
    if (a == 0 || b == 0) {
      return a + b;
    }
    return getGCD(b, a % b);

  }
}

class Point {
  private int x;
  private int y;

  public Point(int[] coordinates) {
    x = coordinates[0];
    y = coordinates[1];
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }
}

class Triangle {

  private Point[] points = new Point[3];
  private int area = 0;

  public Triangle(int[][] coordinates) {
    points[0] = new Point(coordinates[0]);
    points[1] = new Point(coordinates[1]);
    points[2] = new Point(coordinates[2]);
    area = calculateArea();
  }

  public Point point1() {
    return points[0];
  }

  public Point point2() {
    return points[1];
  }

  public Point point3() {
    return points[2];
  }

  public int area() {
    return area;
  }

  private int calculateArea() {
    double sideA = eucledeanDistance(points[0], points[1]);
    double sideB = eucledeanDistance(points[1], points[2]);
    double sideC = eucledeanDistance(points[2], points[0]);
    double semiPerim = (sideA+sideB+sideC)/2;

    return (int) Math.round(Math.sqrt(semiPerim*(semiPerim-sideA)*(semiPerim-sideB)*(semiPerim-sideC)));
  }

  private double eucledeanDistance(Point p1, Point p2) {
    int a = Math.abs(p1.x() - p2.x());
    int b = Math.abs(p1.y() - p2.y());
    return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
  }
}
