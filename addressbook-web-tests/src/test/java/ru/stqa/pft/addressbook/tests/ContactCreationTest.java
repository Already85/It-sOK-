package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase {

  @Test
  public void testAddContact() {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().alll();
    ContactData contact = new ContactData().withFirstname("Alexandr").withMiddlename("Sergeevich").withLastname("Matryuk").withNickname("Kaledo").withAddress("Mars");
    app.goTo().addNew();
    app.contact().create(contact);
    app.goTo().homePage();
    Set<ContactData> after = app.contact().alll();
    Assert.assertEquals(after.size(),before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);
  }
}
