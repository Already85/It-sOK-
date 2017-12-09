package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {

  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
  this.wd=wd;
  }

  public void goToAddNew() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void goToHomePage() {
    wd.findElement(By.linkText("home")).click();
  }
}
