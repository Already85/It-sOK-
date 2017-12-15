package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test

  public void ContactTestModification() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().goToAddNew();
      app.getContactHelper().createContact(new ContactData("Alexandr", "A.S.", "Matryuk", "Squzet", "Snickers", "Leningradskaya oblast`", "6", "8888", "4444", "0000", "1990", "5", "6", "7"));
    }
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initContactModification2();
    app.getContactHelper().clickModify();
    app.getContactHelper().fillContactForm(new ContactData("Pavel", "A.S.", "Malcev", "Squzet", "Snickers", "Leningradskaya oblast`", "6", "8888", "4444", "0000", "1990", "5", "6", "7"));
    app.getContactHelper().submitContactModification();
  }
}