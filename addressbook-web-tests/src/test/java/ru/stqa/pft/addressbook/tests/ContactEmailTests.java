package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

 public class ContactEmailTests extends TestBase {
   @BeforeMethod
   public void ensurePreconditions() {
     app.goTo().homePage();
     if (app.contact().alll().size()==0) {
       app.goTo().addNew();
       app.contact().create(new ContactData().withFirstname("Alexandr").withMiddlename("Sergeevich").withLastname("Matryuk").withNickname("Kaledo").withAddress("Mars").withEmail("Kaledo05@gmail.com").withEmail2("Kaledo28@gmail.com").withEmail3("dr.t-storm@rambler.ru"));
     }
   }
    @Test
    public void testContactEmail() {
      ContactData contact=app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm=app.contact().infoFromEditForm(contact);

      assertThat(contact.getAllEmail(), equalTo(mergeEmail(contactInfoFromEditForm)));
    }

    private String mergeEmail(ContactData contact) {
      return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).stream().filter((s) -> !s.equals(""))
              .map(ContactEmailTests::cleaned)
              .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String email) {
      return email.replaceAll("\\s", "").replaceAll("[()]", "");
    }
  }
