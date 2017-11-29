package ru.stqa.pft.sandbox;

public class MyFirstProgramFunction {
  public static void main(String[] args) {
    PointFunction p1 = new PointFunction(4.0,2.0);
    PointFunction p2 = new PointFunction(8,4);
    System.out.println("Расстояние между двумя точками равно " + distance(p1,p2));
  }
  public static double distance(PointFunction p1, PointFunction p2) {
    return Math.sqrt(Math.pow(p2.x2-p1.x1, 2) + Math.pow(p2.y2-p1.y1, 2) );
  }

}

