package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTest extends TestBase {

  @Test
  public void testDeletionContact() {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().goToAddNew();
      app.getContactHelper().createContact(new ContactData("Alexandr", "A.S.", "Matryuk", "Squzet", "Snickers", "Leningradskaya oblast`", "6", "8888", "4444", "0000", "1990", "5", "6", "7"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().alert();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() -1);

   before.remove(before.size() -1);
   Assert.assertEquals(before,after);
  }

}
