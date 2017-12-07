package ru.stqa.pft.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class AddContactTest {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.cssSelector("html")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @Test
  public void testAddContact() {
    goToAddNewPage();
    fillInTheFieldFirstName("Alexandr");
    fillInTheFieldMiddlename("A.S.");
    fillInTheFieldLastname("Matryuk");
    fillInTheFieldNickname("Squzet");
    fillInTheFieldCompany("Snickers");
    fillInTheFieldAddress("Leningradskaya oblast`");
    fillInTheFieldHome("6");
    fillInTheFieldMobile("8888");
    fillInTheFieldWork("4444");
    fillInTheFieldFax("0000");
    fillInTheFieldAnniversary("1990");
    fillInTheFieldAddress2("5");
    fillInTheFieldPhone2("6");
    fillInTheFieldNotes("7");
    clickButtonEnter();
  }

  private void clickButtonEnter() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillInTheFieldNotes(String notes) {
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys(notes);
  }

  private void fillInTheFieldPhone2(String phone2) {
    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys(phone2);
  }

  private void fillInTheFieldAddress2(String address2) {
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys(address2);
  }

  private void fillInTheFieldAnniversary(String ayear) {
    wd.findElement(By.name("theform")).click();
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[29]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[29]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[7]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[7]")).click();
    }
    wd.findElement(By.name("ayear")).click();
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys(ayear);
  }

  private void fillInTheFieldFax(String fax) {
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(fax);
  }

  private void fillInTheFieldWork(String work) {
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(work);
  }

  private void fillInTheFieldMobile(String mobile) {
    wd.findElement(By.name("theform")).click();
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(mobile);
  }

  private void fillInTheFieldHome(String home) {
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(home);
  }

  private void fillInTheFieldAddress(String address) {
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(address);
  }

  private void fillInTheFieldCompany(String company) {
    wd.findElement(By.name("theform")).click();
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(company);
  }

  private void fillInTheFieldNickname(String nickname) {
    wd.findElement(By.name("theform")).click();
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(nickname);
  }

  private void fillInTheFieldLastname(String lastname) {
    wd.findElement(By.name("theform")).click();
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(lastname);
  }

  private void fillInTheFieldMiddlename(String middlename) {
    wd.findElement(By.name("theform")).click();
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(middlename);
  }

  private void fillInTheFieldFirstName(String firstname) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(firstname);
  }

  private void goToAddNewPage() {
    wd.findElement(By.linkText("add new")).click();
  }
  
  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
