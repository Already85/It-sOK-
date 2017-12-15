package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactDeletionTest extends TestBase {

  @Test
  public void testDeletionContact() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().goToAddNew();
      app.getContactHelper().createContact(new ContactData("Alexandr", "A.S.", "Matryuk", "Squzet", "Snickers", "Leningradskaya oblast`", "6", "8888", "4444", "0000", "1990", "5", "6", "7"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().alert();
  }

}
