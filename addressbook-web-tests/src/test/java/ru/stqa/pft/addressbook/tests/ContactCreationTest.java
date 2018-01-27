package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @DataProvider

  public Iterator<Object[]> validContacts() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
    String xml= "";
    String line = reader.readLine();
    while (line !=null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
    return contacts.stream().map((c)->new Object[] {c}).collect(Collectors.toList()).iterator();
  }}

  @Test(dataProvider = "validContacts")
  public void testAddContact(ContactData contact) {
    Groups groups=app.db().groups();
    app.goTo().homePage();
    Contacts before=app.db().contacts();
    app.contact().create(contact.inGroup(groups.iterator().next()));
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after=app.db().contacts();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    verifyContactListInUI();

  }}




    /*File photo = new File("src/test/resources/1.png");
      ContactData newContact = new ContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo)
              .inGroup(groups.iterator().next());
      app.goTo().homePage();
      app.contact().initContactCreation();
      app.contact().fillContactForm(newContact,true);
      app.contact().submitContactCreation();
      app.contact().returnToHomePage();
    } }*/

