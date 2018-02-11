package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  /*@BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size()==0) {
      app.goTo().addNew();
      app.contact().create(new ContactData() .withFirstname("Alexandr").withMiddlename("Sergeevich").withLastname("Matryuk")
              .withNickname("Kaledo").withAddress("Mars").withEmail("Kaledo05@gmail.com").withEmail2("Kaledo28@gmail.com")
              .withEmail3("dr.t-storm@rambler.ru").withHomePhone("+7(911)88888").withMobilePhone("99 888 7777" ).withWorkPhone("22-33"));
    }
  }*/
  @Test

  public void ContactTestModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    File photo = new File("");
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("").withMiddlename("Sergeevich").withLastname("Matryuk")
            .withNickname("Kaledo").withCompany("Bounty").withAddress("Mars").withEmail("Kaledo05@gmail.com").withEmail2("Kaledo28@gmail.com")
            .withEmail3("dr.t-storm@rambler.ru").withHomePhone("+7(911)88888").withMobilePhone("99 888 7777" ).withWorkPhone("22-33")
            .withFax("122-1").withAyear("1985").withAddress2("BPS").withPhone2("333-333").withNotes("48484").withPhoto(photo);
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertEquals(after.size(),before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
