package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contact")
public class ContactData {

  @XStreamOmitField

  private int id /*= Integer.MAX_VALUE*/;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String company;
  private String address;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String fax;
  private String ayear;
  private String address2;
  private String phone2;
  private String notes;
  private String group;
  private String allPhones;
  private String email;
  private String email2;
  private String email3;
  private String allEmail;
  private String allAddress;
  private File photo;

  @Override
  public String toString() {
    return "ContactData{" + "id='" + id + '\'' + ", firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + ", address='" + address + '\'' +'}';
  }

  public ContactData withId(int id)
  {
    this.id=id;return this; }

  public ContactData withAyear(String ayear) {
    this.ayear=ayear;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname=firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename=middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname=lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname=nickname;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company=company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address=address;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone=homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone=mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone=workPhone;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax=fax;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2=address2;
    return this;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2=phone2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes=notes;
    return this;
  }
  public ContactData withEmail2(String Email2) {
    this.email2=Email2;
    return this;
  }
  public ContactData withEmail(String Email) {
    this.email=Email;
    return this;
  }
  public ContactData withEmail3(String Email3) {
    this.email3=Email3;
    return this;
  }
  public ContactData withAllEmail(String allEmail) {
    this.allEmail=allEmail;
    return this;
  }
  public ContactData withAllPhones(String allPhones) {
    this.allPhones=allPhones;
    return this;
  }
  public ContactData withAllAddress(String allAddress) {
    this.allAddress=allAddress;
    return this;
  }
  public ContactData withPhoto(File photo) {
    this.photo=photo;
    return this;
  }



  public void setId(int id) { this.id=id; }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that=(ContactData) o;

    if (id != that.id) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return address != null ? address.equals(that.address) : that.address == null;
  }

  @Override
  public int hashCode() {
    int result=id;
    result=31 * result + (lastname != null ? lastname.hashCode() : 0);
    result=31 * result + (address != null ? address.hashCode() : 0);
    return result;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getFax() {
    return fax;
  }

  public String getAyear() {
    return ayear;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getNotes() {
    return notes;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getEmail2() { return email2; }

  public String getEmail() { return email; }

  public String getEmail3() { return email3; }

  public String getAllEmail() { return allEmail; }

  public String getAllPhones() { return allPhones; }

  public int getId() {
    return id;
  }

  public String getAllAddress() { return allAddress; }

  public File getPhoto() { return photo; }

  public String getGroup() {
    return group;
  }
}
