package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() { click(By.linkText("add new"));
  }

  public void fillContactForm(ContactData contactData,boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("address"), contactData.getAddress());
    /*type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("company"), contactData.getCompany());
    type(By.name("fax"), contactData.getFax());
    type(By.name("ayear"), contactData.getAyear());
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("phone2"), contactData.getPhone2());
    type(By.name("notes"), contactData.getNotes());


    attach(By.name("photo"), contactData.getPhoto());*/
    if (creation) {
     if (contactData.getGroups().size() > 0) {
       Assert.assertTrue(contactData.getGroups().size() == 1);
       new Select(wd.findElement(By.name("new contact"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new contact")));
    }
  }
  private boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void clickButtonEnter() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void alert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }


  public void create(ContactData contact) {
    fillContactForm(contact,true);
    clickButtonEnter();
  }

  public void modify(ContactData contact) {
    initContactModification();
    fillContactForm(contact,true);
    submitContactModification();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    alert();
  }

  public int Count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts alll() {
    Contacts contacts=new Contacts();
    List<WebElement> elements=wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells=element.findElements(By.tagName("td"));
      String firstname=cells.get(0).getText();
      String lastname=cells.get(1).getText();
      String address=cells.get(3).getText();
      int id=Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address));
    }
    return contacts;
  }

  public Set<ContactData> all() {
    Set<ContactData> contacts=new HashSet<ContactData>();
    List<WebElement> rows=wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells=row.findElements(By.tagName("td"));
      int id=Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname=cells.get(1).getText();
      String firstname=cells.get(2).getText();
      String address=cells.get(3).getText();
      String allEmail=cells.get(4).getText();
      String allPhones=cells.get(5).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAddress(address)
              .withAllEmail(allEmail).withAllPhones(allPhones));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname=wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname=wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone=wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone=wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone=wd.findElement(By.name("work")).getAttribute("value");
    String Email=wd.findElement(By.name("email")).getAttribute("value");
    String Email2=wd.findElement(By.name("email2")).getAttribute("value");
    String Email3=wd.findElement(By.name("email3")).getAttribute("value");
    String Address=wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(homePhone)
            .withMobilePhone(mobilePhone).withWorkPhone(workPhone).withEmail(Email).withEmail2(Email2).withEmail3(Email3).withAddress(Address);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox=wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row=checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells=row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
  public void submitContactCreation() { click(By.name("submit")); }

public void returnToHomePage() {click(By.linkText("home page")); }

  public int count() {return wd.findElements(By.name("selected[]")).size(); }

  private Groups groupCache = null;

  public Groups al() {
    if (groupCache != null) {
      return new Groups(groupCache);
    }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for(WebElement element: elements) {
      String name=element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCache);
  }}