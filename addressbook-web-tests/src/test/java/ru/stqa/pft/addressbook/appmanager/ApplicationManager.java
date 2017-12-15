package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.OPERA;

public class ApplicationManager {

  WebDriver wd;

  private NavigationHelper navigationHelper;
  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private GroupHelper groupHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser=browser;
  }

  public void init() {
    if (browser.equals(BrowserType.FIREFOX)) {
      wd=new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    } else if (browser.equals(BrowserType.CHROME)) {
      wd=new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd=new InternetExplorerDriver();
    } else if (browser.equals(BrowserType.OPERA)) {
      OperaOptions options=new OperaOptions();
      options.setBinary("c:/Program Files/Opera/launcher.exe");
      wd=new OperaDriver(options);}
      wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/group.php");
      groupHelper=new GroupHelper(wd);
      contactHelper=new ContactHelper(wd);
      navigationHelper=new NavigationHelper(wd);
      sessionHelper=new SessionHelper(wd);
      sessionHelper.login("admin", "secret");
    }


  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void stop() {
    wd.quit();
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

}