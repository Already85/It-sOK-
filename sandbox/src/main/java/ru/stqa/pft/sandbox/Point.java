package ru.stqa.pft.sandbox;

  public class Point {
  public double x;
  public double y;

  public Point(double x1, double y1) {
    this.x = x1;
    this.y = y1;
  }

  public Point(int x2, int y2 ) {
    x = x2;
    y = y2;
  }

  public double distance(Point p2) {
    return Math.sqrt(Math.pow(p2.x - this.x, 2) + Math.pow(p2.y - this.y, 2));
  }
}
