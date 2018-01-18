package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.db().contacts().size()==0) {
      app.goTo().addNew();
      app.contact().create(new ContactData().withFirstname("Alexandr").withMiddlename("Sergeevich").withLastname("Matryuk").withNickname("Kaledo").withAddress("Mars"));
    }
  }
  @Test
  public void testDeletionContact() {
    Contacts before = app.contact().alll();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().alll();
    assertThat(app.group().count(), equalTo(before.size() -1));
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
