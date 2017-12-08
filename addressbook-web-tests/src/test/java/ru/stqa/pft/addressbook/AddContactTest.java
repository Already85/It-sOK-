package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

  @Test
  public void testAddContact() {
    goToAddNew();
    fillContactForm(new ContactData("Alexandr", "A.S.", "Matryuk", "Squzet", "Snickers", "Leningradskaya oblast`", "6", "8888", "4444", "0000", "1990", "5", "6", "7"));
    clickButtonEnter();
  }


}
