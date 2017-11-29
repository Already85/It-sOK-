package ru.stqa.pft.sandbox;

public class MyFirstProgram {

 public static void main(String[] args) {
   Point p1 = new Point(4.0,2.0);
   Point p2 = new Point(8,4);
   System.out.println("Расстояние между двумя точками равно " + distance(p1,p2));
 }
public static double distance(Point p1, Point p2) {
     return Math.sqrt(Math.pow(p2.x2-p1.x1, 2) + Math.pow(p2.y2-p1.y1, 2) );
   }

}
