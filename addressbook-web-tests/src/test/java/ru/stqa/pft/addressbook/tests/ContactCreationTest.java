package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testAddContact() {
    app.getNavigationHelper().goToAddNew();
    app.getContactHelper().fillContactForm(new ContactData("Alexandr", "A.S.", "Matryuk", "Squzet", "Snickers", "Leningradskaya oblast`", "6", "8888", "4444", "0000", "1990", "5", "6", "7"));
    app.getContactHelper().clickButtonEnter();
  }


}
