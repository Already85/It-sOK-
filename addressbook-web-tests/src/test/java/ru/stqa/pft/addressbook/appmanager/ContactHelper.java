package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("fax"), contactData.getFax());
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[29]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[3]//option[29]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[7]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[4]//option[7]"));
    }
    type(By.name("ayear"), contactData.getAyear());
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("phone2"), contactData.getPhone2());
    type(By.name("notes"), contactData.getNotes());
  }

  private boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void clickButtonEnter() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void alert() {wd.switchTo().alert().accept();}

  public void initContactModification() {
  click( By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
  click (By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void initContactModification2() {
  click (By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
  }

  public void clickModify() {click(By.name("modifiy")); }

  public void createContact(ContactData contact) {
    fillContactForm(contact);
    clickButtonEnter();
  }

  public boolean isThereAContact() {
  return isElementPresent(By.name("selected[]"));
  }
}