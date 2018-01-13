package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Contacts before = app.contact().alll();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Alexandr").withMiddlename("Sergeevich").withLastname("Matryuk").withNickname("Kaledo").withAddress("Mars").withEmail("Kaledo05@gmail.com").withEmail2("Kaledo28@gmail.com").withEmail3("dr.t-storm@rambler.ru").withHomePhone("+7(911)88888").withMobilePhone("99 888 7777" ).withWorkPhone("22-33");
    app.contact().modify(contact);
    Contacts after = app.contact().alll();
    assertEquals(after.size(),before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
