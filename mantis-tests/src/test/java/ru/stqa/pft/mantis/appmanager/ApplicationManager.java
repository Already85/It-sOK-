package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final Properties properties;
  WebDriver wd;

  private String browser;

  public ApplicationManager(String browser) {
    this.browser=browser;
    properties=new Properties();
  }

  public void init() throws IOException {
    String target=System.getProperty("target","local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

    if (browser.equals(BrowserType.FIREFOX)) {
      wd=new FirefoxDriver(/*new FirefoxOptions().setLegacy(true)*/);
    } else if (browser.equals(BrowserType.CHROME)) {
      wd=new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd=new InternetExplorerDriver();
    } else if (browser.equals(BrowserType.OPERA)) {
      OperaOptions options=new OperaOptions();
      options.setBinary("c:/Program Files/Opera/launcher.exe");
      wd=new OperaDriver(options);}
      wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
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

  public HttpSession newSession() {
  return new HttpSession(this);
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }

}