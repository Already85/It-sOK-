package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;


public class ContactDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().alll().size()==0) {
      app.goTo().addNew();
      app.contact().create(new ContactData().withFirstname("Alexandr").withMiddlename("Sergeevich").withLastname("Matryuk").withNickname("Kaledo").withAddress("Mars"));
    }
  }
  @Test
  public void testDeletionContact() {
    Set<ContactData> before = app.contact().alll();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().alll();
    Assert.assertEquals(after.size(), before.size() -1);

   before.remove(deletedContact);
   Assert.assertEquals(before,after);
  }
}
