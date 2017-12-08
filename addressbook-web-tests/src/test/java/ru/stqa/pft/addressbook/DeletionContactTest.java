package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class DeletionContactTest extends TestBase {

  @Test
  public void testDeletionContact() {
    wd.findElement(By.linkText("home")).click();
    selectContact();
    deleteSelectedContacts();

  }

}
