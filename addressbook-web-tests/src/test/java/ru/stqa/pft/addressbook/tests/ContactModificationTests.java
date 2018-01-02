package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().alll().size()==0) {
      app.goTo().addNew();
      app.contact().create(new ContactData().withFirstname("Alexandr").withMiddlename("Sergeevich").withLastname("Matryuk").withNickname("Kaledo").withAddress("Mars"));
    }
  }
  @Test

  public void ContactTestModification() {
    Set<ContactData> before = app.contact().alll();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Alexandr").withMiddlename("Sergeevich").withLastname("Matryuk").withNickname("Kaledo").withAddress("Mars");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().alll();
    Assert.assertEquals(after.size(),before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before,after);
  }
}
