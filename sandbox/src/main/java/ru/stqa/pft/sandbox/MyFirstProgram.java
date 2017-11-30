package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    Point p1 = new Point(4.0, 2.0);
    Point p2 = new Point(8, 4);
    System.out.println("Расстояние между двумя точками равно " + p1.distance(p2));
  }
  public static double distance(Point p1, Point p2) {
     return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y-p1.y, 2) );

  }

}


