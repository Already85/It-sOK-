package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class ContactDeletionTest extends TestBase {

  @Test
  public void testDeletionContact() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().alert();
  }

}
