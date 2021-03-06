package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().alll().size()==0) {
      app.goTo().addNew();
      app.contact().create(new ContactData().withFirstname("Alexandr").withMiddlename("Sergeevich").withLastname("Matryuk").withNickname("Kaledo").withAddress("Mars"));
    }
  }
  @Test
  public void testContactAddress() {
    app.goTo().homePage();
    ContactData contact=app.contact().alll().iterator().next();
    ContactData contactInfoFromEditForm=app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
  }

  private String mergeAddress(ContactData contact) {
    return Arrays.asList(contact.getAddress()).stream().filter((s) -> !s.equals(""))
            .map(ContactAddressTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String address) {
    return address.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}