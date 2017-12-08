package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class DeletionContactTest extends TestBase {

  @Test
  public void testDeletionContact() {
    app.wd.findElement(By.linkText("home")).click();
    app.selectContact();
    app.deleteSelectedContacts();

  }

}
