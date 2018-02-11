package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {

  @Test
public void testDistance() {

  Point p1 = new Point(5.0, 2.0);
  Point p2 = new Point(8, 4);
    Assert.assertEquals(p1.distance(p2), 3.6055512754639779);
}
}
